package com.applanding.qna.DAO;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	@Override
	public Iterable<Company> findAll(); 
	
}
