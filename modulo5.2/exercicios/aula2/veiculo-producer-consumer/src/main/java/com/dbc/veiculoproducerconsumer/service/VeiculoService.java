package com.dbc.veiculoproducerconsumer.service;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.dbc.veiculoproducerconsumer.Entity.Veiculo;
import com.dbc.veiculoproducerconsumer.dto.VeiculoDTO;
import com.dbc.veiculoproducerconsumer.dto.VeiculoStatsDTO;
import com.dbc.veiculoproducerconsumer.repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {
	private final VeiculoRepository veiculoRepository;
	private final ObjectMapper objectMapper;
	
	
	public String create(VeiculoDTO dto) {
		
		Veiculo veiculo = objectMapper.convertValue(dto, Veiculo.class);
		
		Veiculo save = veiculoRepository.save(veiculo);
		
		return save.getId();
	}
	
	private List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}
	
	public VeiculoStatsDTO velocidadeMedia() {
		
		List<Veiculo> findAll = this.findAll();
		
		OptionalDouble rotacoesTotal = findAll.stream().mapToDouble(v-> v.getRotacao()).average();
		OptionalDouble velocidadesTotal = findAll.stream().mapToDouble(v-> v.getVelocidade()).average();
		
		Double velocidadeAvg = velocidadesTotal.isEmpty()?0:velocidadesTotal.getAsDouble();
		Double rotacaoAvg = rotacoesTotal.isEmpty()?0:rotacoesTotal.getAsDouble();
		
		VeiculoStatsDTO statsDTO = VeiculoStatsDTO.builder().leituras(findAll.size()).mediaRotacao(rotacaoAvg).mediaVelocidade(velocidadeAvg).build();
		
		return statsDTO;
	}
	
}
