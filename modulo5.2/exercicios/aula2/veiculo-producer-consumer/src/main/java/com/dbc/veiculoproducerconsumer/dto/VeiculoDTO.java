package com.dbc.veiculoproducerconsumer.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VeiculoDTO {
	
	@Builder.Default
	private LocalDateTime dataLeitura = LocalDateTime.now();
	private Double velocidade;
	private Integer rotacao;
	private boolean sensorFrenagem;
	
}
