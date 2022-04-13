package com.dbc.kafkachat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dbc.kafkachat.Entity.MessageEntity;

public interface MessageRepository extends MongoRepository<MessageEntity, String> {

	Page<MessageEntity> findAllByIgnoreCaseUsuarioAndIgnoreCaseTopico(String usuario, String topico, Pageable pageble);
	
}
