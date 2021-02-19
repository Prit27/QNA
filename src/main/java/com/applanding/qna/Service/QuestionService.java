package com.applanding.qna.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.AnswerRepository;
import com.applanding.qna.DAO.CommentRepository;
import com.applanding.qna.DAO.CompanyRepository;
import com.applanding.qna.DAO.QuestionCompanyRepository;
import com.applanding.qna.DAO.QuestionRepository;
import com.applanding.qna.DAO.QuestionTagRepository;
import com.applanding.qna.DAO.SubtopicRepository;
import com.applanding.qna.DAO.TopicRepository;
import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.Comment;
import com.applanding.qna.Model.Company;
import com.applanding.qna.Model.Question;
import com.applanding.qna.Model.QuestionTags;
import com.applanding.qna.Model.Subtopic;
import com.applanding.qna.Model.Tags;
import com.applanding.qna.Model.Topic;
import com.applanding.qna.Model.User;
import com.applanding.qna.Request.FilterQuestionRequest;
import com.applanding.qna.Request.QuestionRequest;
import com.applanding.qna.Response.AnswerResponse;
import com.fasterxml.jackson.databind.util.ArrayIterator;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionTagRepository qTagRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private AnswerRepository ansRepo;
	
	@Autowired
	private SubtopicRepository subTopicRepo;
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private QuestionCompanyRepository qCompRepo;
	public Question save(QuestionRequest questionRequest)
	{
		List<Long> tagList = questionRequest.getTags();
		
		Question question = new Question();
		Company company = new Company();
		company.setId(questionRequest.getCompanyId());
		User user = new User();
		user.setId(questionRequest.getUserId());
		question.setCompanyId(questionRequest.getCompanyId());
		question.setDescription(questionRequest.getDescription());
		question.setUserId(questionRequest.getUserId());
		question=questionRepository.save(question);
		
		// code to add the company id;
		
		List<QuestionTags> qtags = new ArrayList<QuestionTags>();
		for(int i=0;i<tagList.size();i++)
		{
			QuestionTags qtag = new QuestionTags();
			Tags tag = new Tags();
			tag.setId(tagList.get(i));
			qtag.setQuestionId(question.getId());
			qtag.setTag(tag);
			qtags.add(qtag);
		}
		
		qTagRepo.saveAll(qtags);
		return question; 
	}
	
	public HashMap<Long, HashMap<String, Object>> filterQuestion(FilterQuestionRequest fqr)
	{
		Iterable<Question> questionList = questionRepository.findAll();
		
		Iterator<Question> it = questionList.iterator();
		
		List<Long> questionTagFilter = new ArrayList<Long>();
		if(!fqr.getTags().isEmpty())
		{
			questionTagFilter = test(fqr.getTags());
		}
		Long counter=1l;
				

		 HashMap<Long, HashMap<String, Object>> outerMap = new HashMap<Long, HashMap<String, Object>>();
		
		
		while(it.hasNext())
		{
			Question quest = it.next();
			if(!(fqr.getCompanies().isEmpty()))
			{
				List<Long> companies = fqr.getCompanies();
				if(companies.contains(quest.getCompanyId()))
				{
					
				}
				else {
					it.remove();
					continue;
				}
			}
			if(!(fqr.getSubtopics().isEmpty()))
			{
				List<Long> subtopics = fqr.getSubtopics();
				if(subtopics.contains(quest.getSubtopicId()))
				{
					
				}
				else {
					it.remove();
					continue;
				}
			}
			if(!(fqr.getTags().isEmpty()))
			{
				if(questionTagFilter.contains(quest.getId()))
				{
			}
				else {

					it.remove();
					continue;
				}
			}
			
			if(fqr.getLikeThreshold()!=0)
			{
				if(quest.getTotalLikes() < fqr.getLikeThreshold())
				{
					it.remove();
					continue;
				}
			}
			Map<Long,String> maxLikedAnswer = new HashMap<Long,String>();
			maxLikedAnswer = ansRepo.findByMaxLikes(quest);
			List<Tags> tags = qTagRepo.getTags(quest.getId());
			List<String> companies = qCompRepo.findByQuestion(quest);
			HashMap<String, Object> innerMap = new HashMap<String,Object>();
			innerMap.put("question_id",quest.getId());
			innerMap.put("question_text",quest.getDescription());
			innerMap.put("companies", quest.getCompanyId());
			innerMap.put("likes", quest.getTotalLikes());
			innerMap.put("answer", maxLikedAnswer.values());
			innerMap.put("tags",tags);
			innerMap.put("companies",companies);
			
			outerMap.put(counter, innerMap);
			counter++;
			
			
		}
		
		return outerMap;
		
		//return questionRepository.findByCompany(fqr.getCompanies());
	}

	

	
	public List<Long> test(List<Long> list) {
	
	//	List<Long> tagList = new ArrayList<Long>(Arrays.asList(1l,2l,3l));
		
		return qTagRepo.filterTags(list);
	}
	
	public Map<String, Object> getByQuestionId(Long id)
	{
		Question quest = questionRepository.findById(id).get();
		
		Map<String,Object> maps = new HashMap<String,Object>();
		
		maps.put("question_text", quest.getDescription());
		
		List<Answer> ansList = ansRepo.findByQuestion(quest);
		
		List<AnswerResponse> ansResponse = new ArrayList<AnswerResponse>();
		
		Iterator<Answer> it = ansList.iterator();
		
		
		
		
		while(it.hasNext())
		{
			Answer answer = it.next();
			List<String> commentList = new ArrayList<String>();
			AnswerResponse answerResponse = new AnswerResponse();
			
			commentList = commentRepo.findByAnswer(answer);
			
			answerResponse.setAnswerText(answer.getDescription());
			answerResponse.setLikes(answer.getTotalLikes());
			answerResponse.setUserId(answer.getUser().getId());
			answerResponse.setComments(commentList);
			
			ansResponse.add(answerResponse);
		}
		maps.put("answers", ansResponse);
		maps.put("likes",quest.getTotalLikes());
		Company company = companyRepo.findById(quest.getCompanyId()).get();
		maps.put("company",company.getName());
		List<String> tags = qTagRepo.findByQuestionId(quest.getId());

		maps.put("tags", tags);
		
		Subtopic subtopic = subTopicRepo.findById(quest.getSubtopicId()).get();
		Topic topic = topicRepo.findById(subtopic.getTopicId()).get();
		
		maps.put("topic", topic);
		
		//maps.put("tags");
		
		return maps;
	}
	
		
		
	
}
