package com.applanding.qna.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.QuestionTags;
import com.applanding.qna.Model.Tags;

public interface QuestionTagRepository extends CrudRepository<QuestionTags, Long> {

//	public void saveAll(List<QuestionTags> quesTags);
	
	@Query("SELECT DISTINCT q.questionId from QuestionTags q where q.tagId in (?1)")
	public List<Long> filterTags(List<Long> tags);
	
	@Query("SELECT q.tagId.tagName from QuestionTags q where q.questionId = ?1")
	List<String> findByQuestionId(Long questionId);
	
	@Query("SELECT q.tagId from QuestionTags q where q.questionId = ?1")
	List<Tags> getTags(Long questionId);
	
	
	@Transactional
	@Modifying
	@Query("update QuestionTags q set q.tagId.id = 0 where q.tagId.id = ?1")
	public void updateTagIdUponRemoval(Long id);
}
