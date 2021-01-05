package com.uai.uaigas.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uai.uaigas.dto.ReclamacaoDTO;
import com.uai.uaigas.services.ReclamacaoService;

@RestController
@RequestMapping(value = "/reclamacao")
public class ReclamacaoResource {
	
	@Autowired
	private ReclamacaoService service;

	@GetMapping
	public ResponseEntity<List<ReclamacaoDTO>> findAll() {	
		List<ReclamacaoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReclamacaoDTO> findById(@PathVariable Long id) {
		ReclamacaoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ReclamacaoDTO> insert(@Valid @RequestBody ReclamacaoDTO dto) {
		ReclamacaoDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	 // NAO IMPLEMENTADO DEVIDO A REGRA DE NEGOCIO
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ReclamacaoDTO> update(@PathVariable Long id, @Valid @RequestBody ReclamacaoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
