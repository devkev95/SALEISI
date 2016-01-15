package com.trabajotoo.saleisi.model;

import java.sql.Time;

public class Bloque {
	
	private int id;
	private Time horaIni;
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
