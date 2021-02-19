package com.applanding.qna.DAO;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.applanding.qna.Model.Topic;

public interface TopicRepository extends CrudRepository<Topic,Long >{

}
