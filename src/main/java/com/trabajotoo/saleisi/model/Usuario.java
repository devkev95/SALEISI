package com.trabajotoo.saleisi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;
	
	@Column(name = "nombre_usuario", length = 300)
	private String nomUsuario;
	
	@Column(name = "pass", length = 350)
	private String password;
	
	@Column(name = "email", length = 250, unique = true)
	private String email;
	
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, 
			orphanRemoval = true)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Set<RolAsignado> rolesAsignados = new HashSet<RolAsignado>();
	
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, 
			orphanRemoval = true)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Set<MateriaAsignada> materiasAsignadas = new HashSet<MateriaAsignada>();
	
	@Column(name = "estado")
	private boolean estado;
	
	
	public Usuario(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<RolAsignado> getRolesAsignados() {
		return rolesAsignados;
	}
	public void setRolesAsignados(Set<RolAsignado> rolesAsignados) {
		this.rolesAsignados = rolesAsignados;
	}
	public Set<MateriaAsignada> getMateriasAsignadas() {
		return materiasAsignadas;
	}
	public void setMateriasAsignadas(Set<MateriaAsignada> materiasAsignadas) {
		this.materiasAsignadas = materiasAsignadas;
	}
	
	public void addMateria(MateriaAsignada matAsign){
		this.materiasAsignadas.add(matAsign);
	}
	
	public void addRol(RolAsignado rolAsign){
		this.rolesAsignados.add(rolAsign);
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
