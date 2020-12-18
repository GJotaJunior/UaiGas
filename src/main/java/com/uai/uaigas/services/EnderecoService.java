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

import com.uai.uaigas.dto.EnderecoDTO;
import com.uai.uaigas.entities.Endereco;
import com.uai.uaigas.repository.EnderecoRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<EnderecoDTO> findAll() {
		List<Endereco> list = repository.findAll();
		return list.stream().map(e -> new EnderecoDTO(e)).collect(Collectors.toList());
	}
	
	public EnderecoDTO findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		Endereco entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new EnderecoDTO(entity);
	}
	
	public EnderecoDTO insert(EnderecoDTO dto) {
		Endereco entity = dto.toEntity();
		entity = repository.save(entity);
		return new EnderecoDTO(entity);
	}
	
	@Transactional
	public EnderecoDTO update(Long id, EnderecoDTO dto) {
		try {
			Endereco entity = repository.getOne(id);
			entity = repository.save(entity);
			return new EnderecoDTO(entity);
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
