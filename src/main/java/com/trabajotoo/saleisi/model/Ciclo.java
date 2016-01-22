package com.trabajotoo.saleisi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciclo")
public class Ciclo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ciclo")
	private int id;
	
	@Column(name = "fecha_inicio")
	private Date fechaIni;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "fecha_final_registro_sol_regulares")
	private Date fechaFinSolRegular;
	
	public Ciclo(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaFinSolRegular() {
		return fechaFinSolRegular;
	}

	public void setFechaFinSolRegular(Date fechaFinSolRegular) {
		this.fechaFinSolRegular = fechaFinSolRegular;
	}
	
	

}
