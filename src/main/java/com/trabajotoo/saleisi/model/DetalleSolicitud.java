package com.trabajotoo.saleisi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_solicitud")
public class DetalleSolicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_solicitud")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_dia")
	private Dia dia;
	
	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
	private Laboratorio laboratorio;
	
	@ManyToOne
	@JoinColumn(name = "id_bloque")
	private Bloque bloque;
	
	public DetalleSolicitud(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	
	

}
