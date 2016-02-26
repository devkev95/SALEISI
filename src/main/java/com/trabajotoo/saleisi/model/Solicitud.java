package com.trabajotoo.saleisi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private int id;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name = "fecha_realizacion")
	private Date fechaRealizada;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} ,orphanRemoval = true)
	@JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
	private Set<DetalleSolicitud> detallesSolicitud = new HashSet<DetalleSolicitud>();
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioSolicitante;
	
	@ManyToOne
	@JoinColumn(name = "id_ciclo")
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
	
	public void addDetalle(DetalleSolicitud det){
		this.detallesSolicitud.add(det);
	}
	
	public void removeDetalle(long id){
		for (DetalleSolicitud det: this.detallesSolicitud){
			if(det.getId() == id){
				this.detallesSolicitud.remove(det);
				break;
			}
		}
	}
	
	

}
