package com.dbc.veiculoproducerconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dbc.veiculoproducerconsumer.Entity.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	
	
}
