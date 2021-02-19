package com.applanding.qna.Response;

import java.util.List;

import com.applanding.qna.Model.Comment;

public class AnswerResponse {

	private String answerText;
	private Long userId;
	private Long likes;
	private List<String> comments;
	
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> commentList) {
		this.comments = commentList;
	}
	
	
}
