package com.applanding.qna.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Answer;
import com.applanding.qna.Model.Question;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

	List<Answer> findByQuestion(Question question);
	
	@Query("SELECT MAX(a.totalLikes),a.description from Answer a where a.question = ?1")
	public Map<Long,String> findByMaxLikes(Question question);
	
	//SELECT description,MAX(total_likes) FROM answer WHERE answer.question_id=3
}
