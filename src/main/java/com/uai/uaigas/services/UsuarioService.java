package com.uai.uaigas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.uai.uaigas.dto.UsuarioDTO;
import com.uai.uaigas.dto.UsuarioInsertDTO;
import com.uai.uaigas.entities.Usuario;
import com.uai.uaigas.repository.UsuarioRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> findAll() {
	List<Usuario> list = repository.findAll();
	return list.stream().map(e -> new UsuarioDTO(e)).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) {
	Optional<Usuario> obj = repository.findById(id);
	Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
	return new UsuarioDTO(entity);
    }
    
    public UsuarioDTO findByEmail(String email) {
	Optional<Usuario> obj = repository.findByEmail(email);
	Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException(email));
	return new UsuarioDTO(entity);
    }
    
    public UsuarioDTO findByEmailAndPassword(String email, String password) {
	Optional<Usuario> obj = repository.findByEmailAndSenha(email, password);
	Usuario entity = obj.orElseThrow(() -> new DatabaseException("O email e/ou senha não estão corretos!"));
	return new UsuarioDTO(entity);
    }

    public UsuarioDTO insert(UsuarioInsertDTO dto) {
	try {
	    Usuario entity = dto.toEntity();
	    insertData(entity);
	    entity = repository.save(entity);
	    return new UsuarioDTO(entity);
	} catch (Exception e) {
	    throw new DatabaseException("Email " + dto.getEmail() + " já cadastrado!");
	}
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
	try {
	    Usuario entity = repository.getOne(id);
	    updateData(entity, dto);
	    entity = repository.save(entity);
	    return new UsuarioDTO(entity);
	} catch (EntityNotFoundException e) {
	    throw new ResourceNotFoundException(id);
	}
    }

    public void delete(Long id) {
	try {
	    repository.deleteById(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new ResourceNotFoundException(id);
	} catch (DataIntegrityViolationException e) {
	    throw new DatabaseException(e.getMessage());
	}
    }
    
    private void updateData(Usuario entity, UsuarioDTO dto) {
	entity.setNome(dto.getNome());
	entity.setEmail(dto.getEmail());
	entity.setFotoUrl(dto.getFotoUrl());
    }
    
    private void insertData(Usuario entity) {
	entity.setAdmin(false);
    }
}
