package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compras")
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String data_compra;
	private double total_compra;
	
	@ManyToOne
	@JoinColumn(name = "viajante_id")
	private Viajantes viajante;
	
	@ManyToOne
	@JoinColumn(name = "destino_id")
	private Destinos destino;

}