package com.applanding.qna.Request;

import java.util.Optional;

public class SubtopicUpdateRequest {

	private Optional<Long> subtopicId;
	private String subtopicName;
	public Optional<Long> getSubtopicId() {
		return subtopicId;
	}
	public void setSubtopicId(Optional<Long> subtopicId) {
		this.subtopicId = subtopicId;
	}
	public String getSubtopicName() {
		return subtopicName;
	}
	public void setSubtopicName(String subtopicName) {
		this.subtopicName = subtopicName;
	}
	
	
}
