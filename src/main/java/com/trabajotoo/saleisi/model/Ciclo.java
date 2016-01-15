package com.trabajotoo.saleisi.model;

import java.util.Date;

public class Ciclo {
	
	private int id;
	private Date fechaIni;
	private Date fechaFin;
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
