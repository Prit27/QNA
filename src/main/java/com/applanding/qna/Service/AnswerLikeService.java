package com.applanding.qna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.AnswerLikeRepository;
import com.applanding.qna.DAO.AnswerRepository;
import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.AnswerLikes;
import com.applanding.qna.Model.User;
import com.applanding.qna.Request.AnswerLikeRequest;

@Service
public class AnswerLikeService {

	@Autowired
	private AnswerLikeRepository ansLikeRepo;
	
	@Autowired
	private AnswerRepository ansRepo;
	
	public void addLike(AnswerLikeRequest ansLikeReq)
	{
		Answer answer = new Answer();
		User user = new User();
		
		answer.setId(ansLikeReq.getAnswer_id());
		user.setId(ansLikeReq.getUser_id());
		
		AnswerLikes ansLikes = new AnswerLikes();
		ansLikes.setAnswer(answer);
		ansLikes.setUser(user);
		
		ansLikeRepo.save(ansLikes);
		
		answer = ansRepo.findById(ansLikeReq.getAnswer_id()).get();
		answer.setTotalLikes(answer.getTotalLikes()+1);
		ansRepo.save(answer);
		
	}
}
