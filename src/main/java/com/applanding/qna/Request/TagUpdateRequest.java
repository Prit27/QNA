package com.applanding.qna.Request;

import java.util.Optional;

public class TagUpdateRequest {

	private Optional<Long> tagId;
	private String tagName;
	public Optional<Long> getTagId() {
		return tagId;
	}
	public void setTagId(Optional<Long> tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
	
}
