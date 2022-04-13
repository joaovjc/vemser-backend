package com.dbc.kafkachat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dbc.kafkachat.Entity.MessageEntity;

public interface MessageRepository extends MongoRepository<MessageEntity, String> {

	
	
}
