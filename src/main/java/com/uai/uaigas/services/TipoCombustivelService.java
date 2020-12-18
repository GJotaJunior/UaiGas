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

import com.uai.uaigas.dto.TipoCombustivelDTO;
import com.uai.uaigas.entities.TipoCombustivel;
import com.uai.uaigas.repository.TipoCombustivelRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class TipoCombustivelService {
	
	@Autowired
	private TipoCombustivelRepository repository;
	
	public List<TipoCombustivelDTO> findAll() {
		List<TipoCombustivel> list = repository.findAll();
		return list.stream().map(e -> new TipoCombustivelDTO(e)).collect(Collectors.toList());
	}
	
	public TipoCombustivelDTO findById(Long id) {
		Optional<TipoCombustivel> obj = repository.findById(id);
		TipoCombustivel entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new TipoCombustivelDTO(entity);
	}
	
	public TipoCombustivelDTO insert(TipoCombustivelDTO dto) {
		TipoCombustivel entity = dto.toEntity();
		entity = repository.save(entity);
		return new TipoCombustivelDTO(entity);
	}
	
	@Transactional
	public TipoCombustivelDTO update(Long id, TipoCombustivelDTO dto) {
		try {
			TipoCombustivel entity = repository.getOne(id);
			entity = repository.save(entity);
			return new TipoCombustivelDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
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
