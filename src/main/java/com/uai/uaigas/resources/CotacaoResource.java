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

import com.uai.uaigas.dto.CotacaoDTO;
import com.uai.uaigas.services.CotacaoService;

@RestController
@RequestMapping(value = "/cotacao")
public class CotacaoResource {

    @Autowired
    private CotacaoService service;

    @GetMapping
    public ResponseEntity<List<CotacaoDTO>> findAll() {
	List<CotacaoDTO> list = service.findAll();
	return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CotacaoDTO> findById(@PathVariable Long id) {
	CotacaoDTO dto = service.findById(id);
	return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CotacaoDTO> insert(@Valid @RequestBody CotacaoDTO dto) {
	CotacaoDTO newDto = service.insert(dto);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
	return ResponseEntity.created(uri).body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
	// NAO IMPLEMENTADO DEVIDO A REGRA DE NEGOCIO
	return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CotacaoDTO> update(@PathVariable Long id, @Valid @RequestBody CotacaoDTO dto) {
	// NAO IMPLEMENTADO DEVIDO A REGRA DE NEGOCIO
	return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

}
