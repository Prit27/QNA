package com.applanding.qna.DAO;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

	public String query = "SELECT q from Question q where q.companyId not in (?1)";
	@Query(query)
	public List<Question> findByCompany(List<Long> list);
	
	
	@Transactional
	@Modifying
	@Query("update Question q set q.companyId = 0 where q.companyId = ?1")
	public void updateCompanyRecords(Long companyId);

}
//" SELECT q from Question q where q.companyId not in (?1) "