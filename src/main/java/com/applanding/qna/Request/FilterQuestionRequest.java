package com.applanding.qna.Request;

import java.util.ArrayList;
import java.util.List;

public class FilterQuestionRequest {

	private List<Long> companies = new ArrayList<Long>();
	private List<Long> subtopics= new ArrayList<Long>();
	private Long likeThreshold=0l;
	private List<Long> tags= new ArrayList<Long>();
	public List<Long> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Long> companies) {
		this.companies = companies;
	}
	public List<Long> getSubtopics() {
		return subtopics;
	}
	public void setSubtopics(List<Long> subtopics) {
		this.subtopics = subtopics;
	}
	public Long getLikeThreshold() {
		return likeThreshold;
	}
	public void setLikeThreshold(Long likeThreshold) {
		this.likeThreshold = likeThreshold;
	}
	public List<Long> getTags() {
		return tags;
	}
	public void setTags(List<Long> tags) {
		this.tags = tags;
	}

	// select * from question q where q.company in <> and q.subtopuc in <> and 
	
}
