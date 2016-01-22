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
@Table(name = "asignacion_materia")
public class MateriaAsignada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignacion_materia")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_materia")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "id_ciclo")
	private Ciclo cicloDeAsignacion;
	
	public MateriaAsignada(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Ciclo getCicloDeAsignacion() {
		return cicloDeAsignacion;
	}
	public void setCicloDeAsignacion(Ciclo cicloDeAsignacion) {
		this.cicloDeAsignacion = cicloDeAsignacion;
	}
	
	

}
