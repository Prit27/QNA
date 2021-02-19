package com.applanding.qna.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.CommentRepository;
import com.applanding.qna.DAO.CompanyRepository;
import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.Comment;
import com.applanding.qna.Model.User;
import com.applanding.qna.Request.CommentRequest;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	

	public Long save(CommentRequest commentReq)
	{
		Answer answer = new Answer();
		answer.setId(commentReq.getAnswerId());
		
		User user = new User();
		user.setId(commentReq.getUserId());
		
		Comment comment = new Comment();
		comment.setAnswer(answer);
		comment.setUser(user);
		comment.setComment(commentReq.getComment());
	
		System.out.println(comment.toString());
		System.out.println(" HEY "+comment.getAnswer().getId());
		comment = commentRepo.save(comment);
		
		
		return comment.getId();
	}
	
	public Iterable<Comment> findAll(){
		return commentRepo.findAll();
	}
	
	public Comment findById(Long id) {
		return commentRepo.findById(id).get();
	}
}
