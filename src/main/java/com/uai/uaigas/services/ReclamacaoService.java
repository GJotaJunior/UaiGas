package com.uai.uaigas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uai.uaigas.dto.ReclamacaoDTO;
import com.uai.uaigas.entities.Reclamacao;
import com.uai.uaigas.repository.ReclamacaoRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class ReclamacaoService {
	
	@Autowired
	private ReclamacaoRepository repository;
	
	public List<ReclamacaoDTO> findAll() {
		List<Reclamacao> list = repository.findAll();
		return list.stream().map(e -> new ReclamacaoDTO(e)).collect(Collectors.toList());
	}
	
	public ReclamacaoDTO findById(Long id) {
		Optional<Reclamacao> obj = repository.findById(id);
		Reclamacao entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ReclamacaoDTO(entity);
	}
	
	public ReclamacaoDTO insert(ReclamacaoDTO dto) {
		Reclamacao entity = dto.toEntity();
		entity = repository.save(entity);
		return new ReclamacaoDTO(entity);
	}
	
	@Transactional
	public ReclamacaoDTO update(Long id, ReclamacaoDTO dto) {
		try {
			Reclamacao entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new ReclamacaoDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Reclamacao entity, ReclamacaoDTO dto) {
		entity.setReclamacaoStatus(dto.getReclamacaoStatus());
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
