package com.applanding.qna.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.SubtopicRepository;
import com.applanding.qna.DAO.TopicRepository;
import com.applanding.qna.Model.Topic;
import com.applanding.qna.Request.TopicUpdateRequest;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private SubtopicRepository subTopicRepo;
	
	public Topic save(Topic topic)
	{
		//topic.setId(UUID.randomUUID());
		return topicRepository.save(topic);
	}
	
	public Iterable<Topic> findAll()
	{
		return topicRepository.findAll();
	}
	
	public Topic findById(Long id)
	{
		return topicRepository.findById(id).get();
	}
	
	public void delete(Long id)
	{
		subTopicRepo.updateTopicId(id);
		topicRepository.deleteById(id);
	}
	
	public void update(TopicUpdateRequest topicUpdateRequest) {
		
		Topic topic = new Topic();
		
		if(topicUpdateRequest.getTopicId().isPresent())
		{
			 topic = topicRepository.findById(topicUpdateRequest.getTopicId().get()).get();
		}
		
		if(!topicUpdateRequest.getTopicName().isEmpty())
		{
			topic.setName(topicUpdateRequest.getTopicName());
			topicRepository.save(topic);
		}
	}
}
