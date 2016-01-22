package com.trabajotoo.saleisi.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bloque")
public class Bloque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bloque")
	private int id;
	
	@Column(name = "hora_inicio")
	private Time horaIni;
	
	@Column(name = "hora_fin")
	private Time horaFin;
	
	public Bloque(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Time horaIni) {
		this.horaIni = horaIni;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	
	

}
