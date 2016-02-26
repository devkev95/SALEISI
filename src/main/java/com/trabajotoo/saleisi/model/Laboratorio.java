package com.trabajotoo.saleisi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_laboratorio")
	private int id;
	
	@Column(name = "cod_laboratorio", length = 8)
	private String codLab;
	
	@Column(name = "capacidad")
	private int capacidad;
	
	@Column(name = "estado")
	private boolean estado;
	
	public Laboratorio(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodLab() {
		return codLab;
	}
	public void setCodLab(String codLab) {
		this.codLab = codLab;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
