package com.applanding.qna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.QuestionLikeRepository;
import com.applanding.qna.DAO.QuestionRepository;
import com.applanding.qna.Model.Question;
import com.applanding.qna.Model.QuestionLikes;
import com.applanding.qna.Model.User;
import com.applanding.qna.Request.QuestionLikeRequest;

@Service
public class QuestionLikeService {

	@Autowired
	private QuestionLikeRepository questLikeRepo;
	
	@Autowired
	private QuestionRepository questRepo;
	
	public void addLike(QuestionLikeRequest questionLikeRequest)
	{
		Question question = new Question();
		User user = new User();
		
		question.setId(questionLikeRequest.getQuestion_id());
		user.setId(questionLikeRequest.getUser_id());
		
		QuestionLikes qlike = new QuestionLikes();
		qlike.setQuestion(question);
		qlike.setUser(user);
		
		questLikeRepo.save(qlike);
		
		question = questRepo.findById(questionLikeRequest.getQuestion_id()).get();
		question.setTotalLikes(question.getTotalLikes()+1);
		questRepo.save(question);
		
		
	}
}
