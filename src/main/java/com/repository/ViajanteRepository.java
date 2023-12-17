package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Viajantes;

@Repository
public interface ViajanteRepository extends JpaRepository<Viajantes, Long> {

}