package com.trabajotoo.saleisi.model;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private int id;
	private String nomUsuario;
	private String password;
	private String email;
	private Set<RolAsignado> rolesAsignados = new HashSet<RolAsignado>();
	private Set<MateriaAsignada> materiasAsignadas = new HashSet<MateriaAsignada>();
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
	
	

}
