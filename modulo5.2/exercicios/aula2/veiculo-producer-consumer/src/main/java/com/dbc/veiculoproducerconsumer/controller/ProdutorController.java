package com.dbc.veiculoproducerconsumer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.veiculoproducerconsumer.dto.VeiculoDTO;
import com.dbc.veiculoproducerconsumer.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    private void enviar(@RequestParam(name = "Rotação") Integer rotacao, @RequestParam(name = "Velocidade") double velocidade, @RequestParam(name = "frenagem") boolean frenagem) throws JsonProcessingException {
        produtorService.enviarVeiculoDTO(VeiculoDTO.builder().rotacao(rotacao).sensorFrenagem(frenagem).velocidade(velocidade).build());
    }
    
    
}