package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {

}
