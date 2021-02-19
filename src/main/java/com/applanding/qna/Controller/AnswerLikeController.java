package com.applanding.qna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Request.AnswerLikeRequest;
import com.applanding.qna.Service.AnswerLikeService;

@RestController
@RequestMapping("/api/answer/like")
public class AnswerLikeController {

	@Autowired
	AnswerLikeService ansLikeService;
	
	@PostMapping("/add")
	public void addLike(@RequestBody AnswerLikeRequest ansLikeRequest)
	{
		ansLikeService.addLike(ansLikeRequest);
	}
}
