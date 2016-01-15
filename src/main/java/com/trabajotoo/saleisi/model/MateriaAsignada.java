package com.trabajotoo.saleisi.model;

public class MateriaAsignada {
	
	private Materia materia;
	private Usuario usuario;
	private Ciclo cicloDeAsignacion;
	
	public MateriaAsignada(){}
	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ciclo getCicloDeAsignacion() {
		return cicloDeAsignacion;
	}
	public void setCicloDeAsignacion(Ciclo cicloDeAsignacion) {
		this.cicloDeAsignacion = cicloDeAsignacion;
	}
	
	

}
