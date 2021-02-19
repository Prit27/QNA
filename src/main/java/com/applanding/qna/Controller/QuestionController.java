package com.applanding.qna.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.Question;
import com.applanding.qna.Request.FilterQuestionRequest;
import com.applanding.qna.Request.QuestionRequest;
import com.applanding.qna.Service.QuestionService;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/post")
	public ResponseEntity<?> postQuestion(@RequestBody QuestionRequest questionRequest){
		Question question = questionService.save(questionRequest);
		
		return new ResponseEntity<>(question.getId(),HttpStatus.CREATED);
	}
	
	@PostMapping("/filter")
	public HashMap<Long, HashMap<String, Object>> filterQuestions(@RequestBody FilterQuestionRequest fqr)
	{
		
		return questionService.filterQuestion(fqr);
	}
	
	@GetMapping("/{questionId}")
	public Map<String,Object> getByQuestionId(@PathVariable Long questionId){
		return questionService.getByQuestionId(questionId);
	}
}
