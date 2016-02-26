package com.trabajotoo.saleisi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trabajotoo.saleisi.model.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Usuario getUserbyUserName(String userName){
		
		return em.createQuery("SELECT DISTINCT u FROM User u JOIN FETCH u.rolesAsignados"
				+ " where u.nomUsuario = :userName", Usuario.class).
				setParameter("userName", userName).getSingleResult();
	}
	
	public Usuario getUserWithMaterias(long id){
		return em.createQuery("SELECT DISTINCT u FROM User u JOIN FETCH u.materiasAsignadas"
				+ " where u.id = :id", Usuario.class)
				.setParameter("id", id).getSingleResult();
	}
	
	public Usuario save(Usuario user){
		em.persist(user);
		return user;
	}

}
