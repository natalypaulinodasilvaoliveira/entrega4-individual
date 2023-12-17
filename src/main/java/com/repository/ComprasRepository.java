package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Long> {

}