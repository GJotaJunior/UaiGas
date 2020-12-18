package com.uai.uaigas.config;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.Reclamacao;
import com.uai.uaigas.entities.TipoCombustivel;
import com.uai.uaigas.entities.enums.ReclamacaoStatus;
import com.uai.uaigas.repository.CombustivelRepository;
import com.uai.uaigas.repository.ReclamacaoRepository;
import com.uai.uaigas.repository.TipoCombustivelRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@Autowired
	private TipoCombustivelRepository tipoCombustivelRepository;
	
	@Autowired
	private CombustivelRepository combustivelRepository;
	
	@Override
	public void run(String... args) throws Exception {


		Reclamacao r1 = new Reclamacao(null,"Preços incompativeis", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);
		Reclamacao r2 = new Reclamacao(null,"Preços totalmente errados", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);
		Reclamacao r3 = new Reclamacao(null,"Mal atendimento", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, null);

		reclamacaoRepository.saveAll(Arrays.asList(r1, r2, r3));
		
		
		TipoCombustivel tc1 = new TipoCombustivel(null, "Aditivada");
		TipoCombustivel tc2 = new TipoCombustivel(null, "Comum");
		TipoCombustivel tc3 = new TipoCombustivel(null, "Premium");
		
		tipoCombustivelRepository.saveAll(Arrays.asList(tc1, tc2, tc3));
		
		
		Combustivel c1 = new Combustivel(null, "Gasolina");
		Combustivel c2 = new Combustivel(null, "Etanol");
		Combustivel c3 = new Combustivel(null, "Diesel");
		
		combustivelRepository.saveAll(Arrays.asList(c1, c2, c3));
		

	}

}