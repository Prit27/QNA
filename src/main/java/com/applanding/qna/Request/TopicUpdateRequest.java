package com.applanding.qna.Request;

import java.util.Optional;

public class TopicUpdateRequest {

	private Optional<Long> topicId;
	private String topicName;
	public Optional<Long> getTopicId() {
		return topicId;
	}
	public void setTopicId(Optional<Long> topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
}
