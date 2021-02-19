package com.applanding.qna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.Company;
import com.applanding.qna.Request.CompanyUpdateRequest;
import com.applanding.qna.Service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/add")
	public ResponseEntity<Company> addCompany(@RequestBody Company company)
	{
		company = companyService.save(company);
		return new ResponseEntity<Company>(company,HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public Iterable<Company> findAll(){
		return companyService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		System.out.println("hheeey  "+id);
		Company company =companyService.findById(id);
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public void deleteById()
	{
		companyService.delete(1l);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Company> updateCompany(@RequestBody CompanyUpdateRequest company)
	{
		return new ResponseEntity<Company>(companyService.update(company),HttpStatus.OK);
	}
}
