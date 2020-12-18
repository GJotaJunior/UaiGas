package com.uai.uaigas.config;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uai.uaigas.entities.Reclamacao;
import com.uai.uaigas.entities.enums.ReclamacaoStatus;
import com.uai.uaigas.repository.ReclamacaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;

	@Override
	public void run(String... args) throws Exception {


		Reclamacao r1 = new Reclamacao(null,"Preços incompativeis", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);
		Reclamacao r2 = new Reclamacao(null,"Preços totalmente errados", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);
		Reclamacao r3 = new Reclamacao(null,"Mal atendimento", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);

		reclamacaoRepository.saveAll(Arrays.asList(r1, r2, r3));

	}

}