package com.trabajotoo.saleisi.model;

public class Laboratorio {
	
	private int id;
	private String codLab;
	private int capacidad;
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
