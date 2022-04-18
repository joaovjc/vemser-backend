package com.dbc.pessoaapi.security;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailServiceDois;
import com.dbc.pessoaapi.service.TypeT;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScheduledTask {
	private final PessoaRepository pessoaRepository;
	private final EmailServiceDois emailService;
	
	@Scheduled(cron = "0 0 8,20 * * *")
	public void enviarEmail() {
		pessoaRepository.listPorSemEndereco().forEach(p->emailService.sendEmail(p, p.getEmail(), TypeT.NORMAL));
	}
	
	@Scheduled(cron = "0 0 0 1 * *")
	public void enviarEmailPromo() {
		pessoaRepository.findAll().forEach(p->emailService.sendEmail(p, p.getEmail(), TypeT.MENOS_NORMAL));
	}
	
	@Scheduled(cron = "0 0 8 * * *")
	public void enviarEmailAniver() {
		pessoaRepository.listPorAniverHoje().forEach(p->emailService.sendEmail(p, p.getEmail(), TypeT.ANIVER));
	}
}
