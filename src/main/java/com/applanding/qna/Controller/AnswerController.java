package com.applanding.qna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.Answer;
import com.applanding.qna.Request.AnswerRequest;
import com.applanding.qna.Service.AnswerService;

@RestController
@RequestMapping("/api/{question}/answer")
public class AnswerController {

	@Autowired
	private AnswerService ansService;
	
	
	@PostMapping("/post")
	public ResponseEntity<?> add(@RequestBody AnswerRequest ansReq)
	{
		return new ResponseEntity<>(ansService.save(ansReq).getId(),HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public Iterable<Answer> findAll(){
		return  ansService.findAll();
	}
	
	@GetMapping("/{answerId}")
	public ResponseEntity<Answer> findById(@PathVariable Long answerId)
	{
		return new ResponseEntity<Answer>(ansService.findById(answerId),HttpStatus.OK);
	}
}
