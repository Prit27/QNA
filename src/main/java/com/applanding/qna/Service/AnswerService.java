package com.applanding.qna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.AnswerRepository;
import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.Question;
import com.applanding.qna.Model.User;
import com.applanding.qna.Request.AnswerRequest;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository ansRepo;
	
	
	public Answer save(AnswerRequest answerRequest)
	{
		User user = new User();
		user.setId(answerRequest.getUserId());
		
		Question question = new Question();
		question.setId(answerRequest.getQuestionId());
		
		Answer answer = new Answer();
		answer.setDescription(answerRequest.getDescription());
		answer.setQuestion(question);
		answer.setUser(user);
		answer = ansRepo.save(answer);
		
		return answer;
	}
	
	public Iterable<Answer> findAll(){
		return ansRepo.findAll();
	}
	
	public Answer findById(Long id)
	{
		return ansRepo.findById(id).get();
	}
}
