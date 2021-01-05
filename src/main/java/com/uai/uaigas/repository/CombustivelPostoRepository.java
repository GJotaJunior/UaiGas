package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.CombustivelPosto;

@Repository
public interface CombustivelPostoRepository extends JpaRepository<CombustivelPosto, Long> {

}
