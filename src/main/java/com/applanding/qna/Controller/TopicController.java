package com.applanding.qna.Controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.Topic;
import com.applanding.qna.Request.TopicUpdateRequest;
import com.applanding.qna.Service.TopicService;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@PostMapping("/add")
	public ResponseEntity<Topic> addTag(@RequestBody Topic topic)
	{
		topic = topicService.save(topic);
		return new ResponseEntity<Topic>(topic,HttpStatus.CREATED);
		
	}
	
	@GetMapping("")
	public Iterable<Topic> findAll(){
		return topicService.findAll();
	}
	
	@GetMapping("/{topicId}")
	public ResponseEntity<Topic> findById(@PathVariable Long topicId)
	{
		return new ResponseEntity<Topic>(topicService.findById(topicId),HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public HttpStatus delete(@RequestBody  Map<String,Long> idMap)
	{
		topicService.delete(idMap.get("id"));
		return HttpStatus.OK;
	}
	
	@PostMapping("/update")
	public HttpStatus update(@RequestBody TopicUpdateRequest topicUpdateRequest )
	{
		topicService.update(topicUpdateRequest);
		return HttpStatus.OK;
	}
}
