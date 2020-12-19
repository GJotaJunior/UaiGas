package com.uai.uaigas.services;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.entities.Cotacao;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.entities.Reclamacao;
import com.uai.uaigas.entities.TipoCombustivel;
import com.uai.uaigas.entities.Usuario;
import com.uai.uaigas.entities.enums.PostoStatus;
import com.uai.uaigas.entities.enums.ReclamacaoStatus;
import com.uai.uaigas.repository.CombustivelRepository;
import com.uai.uaigas.repository.CotacaoRepository;
import com.uai.uaigas.repository.PostoRepository;
import com.uai.uaigas.repository.ReclamacaoRepository;
import com.uai.uaigas.repository.TipoCombustivelRepository;
import com.uai.uaigas.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private PostoRepository postoRepository;
	
	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@Autowired
	private TipoCombustivelRepository tipoCombustivelRepository;
	
	@Autowired
	private CombustivelRepository combustivelRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CotacaoRepository cotacaoRepository;

	public void InstantiateDatabase() {
		Posto p1 = new Posto(null, "Posto Ipiranga", PostoStatus.ATIVO);
		Posto p2 = new Posto(null, "Posto Shell", PostoStatus.INATIVO);
		Posto p3 = new Posto(null, "Posto Petrobras", PostoStatus.BLOQUEADO);
		
		postoRepository.saveAll(Arrays.asList(p1, p2, p3));


		Reclamacao r1 = new Reclamacao(null,"Preços incompativeis", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, p1);
		Reclamacao r2 = new Reclamacao(null,"Preços totalmente errados", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, p2);
		Reclamacao r3 = new Reclamacao(null,"Mal atendimento", Calendar.getInstance(), ReclamacaoStatus.AGUARDANDO, p1);

		reclamacaoRepository.saveAll(Arrays.asList(r1, r2, r3));
		
		
		TipoCombustivel tc1 = new TipoCombustivel(null, "Aditivada");
		TipoCombustivel tc2 = new TipoCombustivel(null, "Comum");
		TipoCombustivel tc3 = new TipoCombustivel(null, "Premium");
		
		tipoCombustivelRepository.saveAll(Arrays.asList(tc1, tc2, tc3));
		
		
		Combustivel c1 = new Combustivel(null, "Gasolina");
		Combustivel c2 = new Combustivel(null, "Etanol");
		Combustivel c3 = new Combustivel(null, "Diesel");
		
		combustivelRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Usuario u1 = Usuario.builder().nome("Jose").email("jose@gmail.com").senha("123456").admin(false).build();
		Usuario u2 = Usuario.builder().nome("Maria").email("maria@gmail.com").senha("123456").admin(false).build();
		Usuario u3 = Usuario.builder().nome("Carlos").email("carlos@gmail.com").senha("123456").admin(false).build();
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Cotacao cot1 = Cotacao.builder().preco(20.0).dataHora(Calendar.getInstance()).combustivel(c3).build();
		Cotacao cot2 = Cotacao.builder().preco(17.0).dataHora(Calendar.getInstance()).combustivel(c1).build();
		Cotacao cot3 = Cotacao.builder().preco(19.35).dataHora(Calendar.getInstance()).combustivel(c2).build();
	
		cotacaoRepository.saveAll(Arrays.asList(cot1, cot2, cot3));
	}

}
