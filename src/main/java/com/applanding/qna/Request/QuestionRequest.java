package com.applanding.qna.Request;

import java.util.List;

public class QuestionRequest {

	private String description;
	private Long companyId;
	private Long subtopicId;
	private Long userId;
	private List<Long> tags;
	
	
	public List<Long> getTags() {
		return tags;
	}
	public void setTags(List<Long> tags) {
		this.tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getSubtopicId() {
		return subtopicId;
	}
	public void setSubtopicId(Long subtopicId) {
		this.subtopicId = subtopicId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
