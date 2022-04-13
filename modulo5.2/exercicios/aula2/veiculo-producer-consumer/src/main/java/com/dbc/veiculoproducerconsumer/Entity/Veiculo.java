package com.dbc.veiculoproducerconsumer.Entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("veiculo")
public class Veiculo {
	
	private String id;
	private LocalDateTime dataLeitura;
	private Double velocidade;
	private Integer rotacao;
	private boolean sensorFrenagen;
}
