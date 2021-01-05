package com.uai.uaigas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.uai.uaigas.dto.PostoDTO;
import com.uai.uaigas.entities.Posto;
import com.uai.uaigas.repository.PostoRepository;
import com.uai.uaigas.services.exceptions.DatabaseException;
import com.uai.uaigas.services.exceptions.ResourceNotFoundException;

@Service
public class PostoService {
	
	@Autowired
    private PostoRepository repository;

    public Page<PostoDTO> findAllPaged(PageRequest pageRequest) {
	Page<Posto> list = repository.findAll(pageRequest);
	return list.map(e -> new PostoDTO(e));
    }

    public PostoDTO findById(Long id) {
	Optional<Posto> obj = repository.findById(id);
	Posto entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
	return new PostoDTO(entity);
    }

    public PostoDTO insert(PostoDTO dto) {
    	Posto entity = dto.toEntity();
    	entity = repository.save(entity);
    	return new PostoDTO(entity);
    }

    @Transactional
    public PostoDTO update(Long id, PostoDTO dto) {
	try {
		Posto entity = repository.getOne(id);
	    updateData(entity, dto);
	    entity = repository.save(entity);
	    return new PostoDTO(entity);
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
    
    private void updateData(Posto entity, PostoDTO dto) {
    	entity.setStatus(dto.getStatus());
    }
    
}
