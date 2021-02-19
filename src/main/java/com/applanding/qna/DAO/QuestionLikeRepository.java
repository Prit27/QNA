package com.applanding.qna.DAO;

import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.QuestionLikes;

public interface QuestionLikeRepository extends CrudRepository<QuestionLikes, Long>{
	
	
}
