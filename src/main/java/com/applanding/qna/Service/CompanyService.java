package com.applanding.qna.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.CompanyRepository;
import com.applanding.qna.DAO.QuestionCompanyRepository;
import com.applanding.qna.DAO.QuestionRepository;
import com.applanding.qna.Model.Company;
import com.applanding.qna.Request.CompanyUpdateRequest;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private QuestionRepository quesRepo;
	
	@Autowired
	private QuestionCompanyRepository qCompRepo;
	
	public Company save(Company company)
	{
		return companyRepository.save(company);
	}
	
	public Iterable<Company> findAll(){
		return companyRepository.findAll();
	}
	
	public Company findById(Long id)
	{
		return companyRepository.findById(id).get();
	}
	
	public  void delete(Long id)
	{
		quesRepo.updateCompanyRecords(id);
		qCompRepo.updateCompany(id);
		companyRepository.deleteById(id);
	}
	
	public Company update(CompanyUpdateRequest company)
	{
		Company companyFetched = new Company();
		if(company.getCompanyId().isPresent())
		{
			companyFetched = companyRepository.findById(company.getCompanyId().get()).get();
		}
		if(!company.getCompanyName().isEmpty())
		{
			companyFetched.setName(company.getCompanyName());
			companyRepository.save(companyFetched);
		}
		return companyFetched;
	}
}
