package com.dbc.pessoaapi.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.dbc.pessoaapi.entity.PessoaEntity;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceDois {

	private final freemarker.template.Configuration fmConfiguration;

	@Value("${spring.mail.username}")
	private String from;
	private final JavaMailSender emailSender;
	private File dirPath = new File("src/main/resources/templates");

	public void sendEmail(PessoaEntity user, String email, TypeT type) {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setSubject("test");
			mimeMessageHelper.setText(geContentFromTemplate(user,type), true);

			emailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

	public String geContentFromTemplate(PessoaEntity user, TypeT type) throws IOException, TemplateException {
		Map<String, Object> dados = new HashMap<>();
		Template template = null;
		dados.put("nome", user.getNome());

		fmConfiguration.setDirectoryForTemplateLoading(dirPath);
		if(type.equals(TypeT.NORMAL)) {
			template = fmConfiguration.getTemplate("/email-schedule-template.ftl");
		}else if(type.equals(TypeT.MENOS_NORMAL)){
			template = fmConfiguration.getTemplate("/email-schedule-promo.ftl");
		}else{
			dados.put("data", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM")));
			dados.put("idade", ( (LocalDateTime.now().getYear())  - (user.getDataNascimento().getYear()) ));
			template = fmConfiguration.getTemplate("/email-schedule-aniver.ftl");
		}
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
		return html;
	}
}