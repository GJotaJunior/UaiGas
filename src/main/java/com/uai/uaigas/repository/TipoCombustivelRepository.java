package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.TipoCombustivel;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivel, Long> {

}
