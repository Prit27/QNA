package com.applanding.qna.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.SubtopicRepository;
import com.applanding.qna.Model.Subtopic;
import com.applanding.qna.Model.Topic;
import com.applanding.qna.Request.SubtopicUpdateRequest;

@Service
public class SubtopicService {

	@Autowired
	private SubtopicRepository subRepo;
	
	public Subtopic save(Subtopic subtopic, Long topicId)
	{
		subtopic.setTopicId(topicId);
		return subRepo.save(subtopic);
	}
	
	public Iterable<Subtopic> findAll(){
		return subRepo.findAll();
	}
	
	public Subtopic findById(Long id) {
		return subRepo.findById(id).get();
	}
	
	public void delete(Long id)
	{
		subRepo.deleteById(id);
	}
	public void update(SubtopicUpdateRequest subtopicUpdateReq)
	{
		Subtopic subtopic = new Subtopic();
		if(subtopicUpdateReq.getSubtopicId().isPresent())
		{
			subtopic = subRepo.findById(subtopicUpdateReq.getSubtopicId().get()).get();
		}
		if(!subtopicUpdateReq.getSubtopicName().isEmpty())
		{
			subtopic.setName(subtopicUpdateReq.getSubtopicName());
			subRepo.save(subtopic);
		}
	}
}
