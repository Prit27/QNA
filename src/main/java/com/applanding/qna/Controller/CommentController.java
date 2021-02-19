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

import com.applanding.qna.Model.Comment;
import com.applanding.qna.Request.CommentRequest;
import com.applanding.qna.Service.CommentService;

@RestController
@RequestMapping("/api/{answer}/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody CommentRequest commentRequest,@PathVariable Long answer)
	{
		commentRequest.setAnswerId(answer);
		return new ResponseEntity<>(commentService.save(commentRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public Iterable<Comment> findAll(){
		return commentService.findAll();
	}
	
	@GetMapping("/{commentId}")
	public ResponseEntity<Comment> findById(@PathVariable Long commentId)
	{
		return new ResponseEntity<Comment>(commentService.findById(commentId),HttpStatus.OK);
	}

}
