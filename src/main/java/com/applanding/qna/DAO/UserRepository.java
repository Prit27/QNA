package com.applanding.qna.DAO;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.User;

public interface UserRepository extends CrudRepository<User,Long>{

}
