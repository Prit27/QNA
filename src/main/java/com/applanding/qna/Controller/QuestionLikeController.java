package com.applanding.qna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.QuestionLikes;
import com.applanding.qna.Request.QuestionLikeRequest;
import com.applanding.qna.Service.QuestionLikeService;

@RestController
@RequestMapping("/api/question/like")
public class QuestionLikeController {

	@Autowired
	private QuestionLikeService questLikeService;
	
	@PostMapping("/add")
	private void addALike(@RequestBody QuestionLikeRequest questLikeRequest)
	{
		questLikeService.addLike(questLikeRequest);
	}
}
