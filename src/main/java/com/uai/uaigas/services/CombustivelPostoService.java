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

import com.uai.uaigas.dto.CombustivelPostoDTO;
import com.uai.uaigas.entities.CombustivelPosto;
import com.uai.uaigas.repository.CombustivelPostoRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class CombustivelPostoService {
	
	@Autowired
	private CombustivelPostoRepository repository;
	
	public List<CombustivelPostoDTO> findAll() {
		List<CombustivelPosto> list = repository.findAll();
		return list.stream().map(e -> new CombustivelPostoDTO(e)).collect(Collectors.toList());
	}
	
	public CombustivelPostoDTO findById(Long id) {
		Optional<CombustivelPosto> obj = repository.findById(id);
		CombustivelPosto entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CombustivelPostoDTO(entity);
	}
	
	public CombustivelPostoDTO insert(CombustivelPostoDTO dto) {
		CombustivelPosto entity = dto.toEntity();
		entity = repository.save(entity);
		return new CombustivelPostoDTO(entity);
	}
	
	@Transactional
	public CombustivelPostoDTO update(Long id, CombustivelPostoDTO dto) {
		try {
			CombustivelPosto entity = repository.getOne(id);
			entity = repository.save(entity);
			return new CombustivelPostoDTO(entity);
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
