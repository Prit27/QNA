package com.applanding.qna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.QuestionCompany;
import com.applanding.qna.Request.QuestionCompanyRequest;
import com.applanding.qna.Service.QuestionCompanyService;

@RestController
@RequestMapping("/api/question/company")
public class QuestionCompanyController {

	@Autowired
	private QuestionCompanyService qCompServ;
	
	@PostMapping("/add")
	public ResponseEntity<QuestionCompany> add(@RequestBody QuestionCompanyRequest qCompReq)
	{
		return new ResponseEntity<QuestionCompany>(qCompServ.add(qCompReq),HttpStatus.CREATED);
	}
	
}
