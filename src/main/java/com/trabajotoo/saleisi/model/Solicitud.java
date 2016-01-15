package com.trabajotoo.saleisi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solicitud {
	
	private int id;
	private boolean estado;
	private Date fechaRealizada;
	private Set<DetalleSolicitud> detallesSolicitud = new HashSet<DetalleSolicitud>();
	private Usuario usuarioSolicitante;
	private Ciclo cicloRealizado;
	
	public Solicitud(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Date getFechaRealizada() {
		return fechaRealizada;
	}
	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}
	public Set<DetalleSolicitud> getDetallesSolicitud() {
		return detallesSolicitud;
	}
	public void setDetallesSolicitud(Set<DetalleSolicitud> detallesSolicitud) {
		this.detallesSolicitud = detallesSolicitud;
	}
	public Usuario getUsuarioSolicitante() {
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public Ciclo getCicloRealizado() {
		return cicloRealizado;
	}

	public void setCicloRealizado(Ciclo cicloRealizado) {
		this.cicloRealizado = cicloRealizado;
	}
	
	

}
