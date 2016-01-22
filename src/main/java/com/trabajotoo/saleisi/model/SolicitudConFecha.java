package com.trabajotoo.saleisi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud_con_fecha")
public class SolicitudConFecha extends Solicitud {
	
	@Column(name = "tipo")
	private int tipo;
	
	@Column(name = "fecha_inicio")
	private Date fechaIni;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "motivo", length = 350)
	private String motivo;
	
	public SolicitudConFecha() {
		super();
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
