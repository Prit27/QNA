package com.applanding.qna.Request;

import java.util.Optional;

public class CompanyUpdateRequest {

	private Optional<Long> companyId;
	private String companyName;
	public Optional<Long> getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Optional<Long> companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
