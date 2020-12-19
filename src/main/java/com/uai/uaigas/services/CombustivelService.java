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

import com.uai.uaigas.dto.CombustivelDTO;
import com.uai.uaigas.entities.Combustivel;
import com.uai.uaigas.repository.CombustivelRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class CombustivelService {
	
	@Autowired
	private CombustivelRepository repository;
	
	public List<CombustivelDTO> findAll() {
		List<Combustivel> list = repository.findAll();
		return list.stream().map(e -> new CombustivelDTO(e)).collect(Collectors.toList());
	}
	
	public CombustivelDTO findById(Long id) {
		Optional<Combustivel> obj = repository.findById(id);
		Combustivel entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CombustivelDTO(entity);
	}
	
	public CombustivelDTO insert(CombustivelDTO dto) {
		Combustivel entity = dto.toEntity();
		entity = repository.save(entity);
		return new CombustivelDTO(entity);
	}
	
	@Transactional
	public CombustivelDTO update(Long id, CombustivelDTO dto) {
		try {
			Combustivel entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new CombustivelDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Combustivel entity, CombustivelDTO dto) {
		entity.setNome(dto.getNome());
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
