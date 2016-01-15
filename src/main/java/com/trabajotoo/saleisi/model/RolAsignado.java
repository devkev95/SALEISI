package com.trabajotoo.saleisi.model;

public class RolAsignado {
	
	private Rol rol;
	private Usuario usuario;
	private boolean estado;
	
	public RolAsignado(){}
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
