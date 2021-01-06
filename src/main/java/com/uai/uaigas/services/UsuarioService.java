package com.uai.uaigas.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
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
    
    @Autowired
    private EmailService emailService;
    
    private Random rand = new Random();

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
    public UsuarioDTO update(UsuarioDTO dto) {
	try {
	    Usuario entity = repository.getOne(dto.getId());
	    updateData(entity, dto);
	    entity = repository.save(entity);
	    return new UsuarioDTO(entity);
	} catch (EntityNotFoundException e) {
	    throw new ResourceNotFoundException(dto.getId());
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

    public void sendNewPassword(String email) {
	Usuario usuario = findByEmail(email).toEntity();
	if (usuario == null) throw new ResourceNotFoundException(email);
	
	String newPassword = newPassword();
	usuario.setSenha(newPassword);
	
	usuario = repository.save(usuario);
	emailService.sendNewPasswordEmail(usuario, newPassword);
    }
    
    private String newPassword() {
	char[] vet = new char[6];
	
	for (int i = 0; i < vet.length; i++) {
	    vet[i] = randomChar();
	}
	
	return new String(vet);
    }
    
    private char randomChar() {
	int opt = rand.nextInt(3);
	if (opt == 0) { // gera um digito
	    return (char) (rand.nextInt(10) + 48);
	} else if (opt == 1) { // gera letra maiuscula
	    return (char) (rand.nextInt(26) + 65);
	} else { // gera letra minuscula
	    return (char) (rand.nextInt(26) + 97);
	}
    }
}
