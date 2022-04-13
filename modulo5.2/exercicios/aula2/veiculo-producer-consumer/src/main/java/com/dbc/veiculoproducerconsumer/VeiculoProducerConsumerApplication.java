package com.dbc.veiculoproducerconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class VeiculoProducerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculoProducerConsumerApplication.class, args);
	}

}
