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

import com.applanding.qna.Model.Subtopic;
import com.applanding.qna.Model.Topic;
import com.applanding.qna.Request.SubtopicUpdateRequest;
import com.applanding.qna.Service.SubtopicService;

@RestController
@RequestMapping("/api/{topic}/subtopic")
public class SubtopicController {

	@Autowired
	private SubtopicService subTopicService;
	
	@PostMapping("/add")
	public ResponseEntity<Subtopic> add(@RequestBody Subtopic subtopic,@PathVariable Long topic)
	{
		subtopic = subTopicService.save(subtopic,topic);
		return new ResponseEntity<Subtopic>(subtopic,HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public Iterable<Subtopic> findAll(){
		return subTopicService.findAll();
	}
	
	@GetMapping("/{subtopicId}")
	public ResponseEntity<Subtopic> findById(@PathVariable Long subtopicId)
	{
		return new ResponseEntity<Subtopic>(subTopicService.findById(subtopicId),HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public HttpStatus delete(@RequestBody Map<String,Long> deleteMap)
	{
		subTopicService.delete(deleteMap.get("id"));
		return HttpStatus.OK;
	}
	
	@PostMapping("/update")
	public HttpStatus update(@RequestBody SubtopicUpdateRequest subtopicUpdateReq)
	{
		subTopicService.update(subtopicUpdateReq);
		return HttpStatus.OK;
	}
}
