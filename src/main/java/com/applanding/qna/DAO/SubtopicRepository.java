package com.applanding.qna.DAO;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Subtopic;

public interface SubtopicRepository extends CrudRepository<Subtopic, Long>{

	
	@Transactional
	@Modifying
	@Query("update Subtopic s set s.topicId = 0 where s.topicId = ?1")
	public void updateTopicId(Long id);
}
