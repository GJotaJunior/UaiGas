package com.uai.uaigas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uai.uaigas.dto.CotacaoDTO;
import com.uai.uaigas.entities.Cotacao;
import com.uai.uaigas.repository.CotacaoRepository;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository repository;
    
    public List<CotacaoDTO> findAll() {
	List<Cotacao> list = repository.findAll();
	return list.stream().map(e -> new CotacaoDTO(e)).collect(Collectors.toList());
    }
    
    public CotacaoDTO findById(Long id) {
	Optional<Cotacao> obj = repository.findById(id);
	Cotacao entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
	return new CotacaoDTO(entity);
    }
    
    public CotacaoDTO insert(CotacaoDTO dto) {
	Cotacao entity = dto.toEntity();
	entity = repository.save(entity);
	return new CotacaoDTO(entity);
    }
    
}
