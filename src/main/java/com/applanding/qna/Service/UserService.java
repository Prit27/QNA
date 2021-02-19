package com.applanding.qna.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.UserRepository;
import com.applanding.qna.Model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User save(User user) {
		return userRepo.save(user);
	}
}
