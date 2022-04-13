package com.dbc.veiculoproducerconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.veiculoproducerconsumer.dto.VeiculoStatsDTO;
import com.dbc.veiculoproducerconsumer.service.VeiculoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OperacoesController {
	private final VeiculoService veiculoService;
	
	@GetMapping("/status")
	public VeiculoStatsDTO status() {
		return veiculoService.velocidadeMedia();
	}
	
}
