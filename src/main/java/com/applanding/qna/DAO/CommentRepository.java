package com.applanding.qna.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

	
	@Query(" Select c.comment from Comment c where c.answer = ?1")
	List<String> findByAnswer(Answer answer);
}
