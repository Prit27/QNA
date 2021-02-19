package com.applanding.qna.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Question;
import com.applanding.qna.Model.QuestionCompany;

public interface QuestionCompanyRepository extends CrudRepository<QuestionCompany, Long>{

	
	@Query("SELECT q.company.name from QuestionCompany q where q.question=?1")
	List<String> findByQuestion(Question question);
	
	
	@Transactional
	@Modifying
	@Query("update QuestionCompany q set q.company.id=0 where q.company.id = ?1")
	public void updateCompany(Long companyId);
}
