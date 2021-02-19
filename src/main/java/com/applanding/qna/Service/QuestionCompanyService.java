package com.applanding.qna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.QuestionCompanyRepository;
import com.applanding.qna.Model.Company;
import com.applanding.qna.Model.Question;
import com.applanding.qna.Model.QuestionCompany;
import com.applanding.qna.Request.QuestionCompanyRequest;

@Service
public class QuestionCompanyService {

	@Autowired
	private QuestionCompanyRepository qCompRepo;
	
	public QuestionCompany add(QuestionCompanyRequest qCompReq)
	{
		Question question = new Question();
		Company company = new Company();
		question.setId(qCompReq.getQuestion_id());
		company.setId(qCompReq.getCompany_id());
		QuestionCompany qComp = new QuestionCompany();
		qComp.setQuestion(question);
		qComp.setCompany(company);	
		
		return qCompRepo.save(qComp);
		
	}
	
}
