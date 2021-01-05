package com.uai.uaigas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uai.uaigas.entities.Posto;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long> {

}
