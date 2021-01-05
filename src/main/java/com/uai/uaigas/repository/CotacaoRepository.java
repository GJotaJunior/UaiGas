package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.Cotacao;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

}
