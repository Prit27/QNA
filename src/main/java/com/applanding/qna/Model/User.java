package com.applanding.qna.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username",unique = true)
	private String username;

	@Column(name = "password")
	private String password;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Question> getQuestions_posted() {
		return questions_posted;
	}

	public void setQuestions_posted(List<Question> questions_posted) {
		this.questions_posted = questions_posted;
	}

	@OneToMany(mappedBy = "userId")
	private List<Question> questions_posted;
}