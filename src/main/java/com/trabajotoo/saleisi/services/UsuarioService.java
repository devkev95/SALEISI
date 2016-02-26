package com.trabajotoo.saleisi.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajotoo.saleisi.dao.UsuarioDAO;
import com.trabajotoo.saleisi.model.Materia;
import com.trabajotoo.saleisi.model.MateriaAsignada;
import com.trabajotoo.saleisi.model.Usuario;

@Service("usuarioService")
public class UsuarioService {
	
	@Autowired
    private	UsuarioDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Usuario findByUsername(String userName){
		return dao.getUserbyUserName(userName);
	}
	
	@Transactional
	public Usuario save(Usuario user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return dao.save(user);
	}
	
	@Transactional
	public Materia getMateriaImpartida(Usuario user){
		user = dao.getUserWithMaterias(user.getId());
		Date fechaHoy = new Date();
		Materia mat = null;
		for(MateriaAsignada matAsign: user.getMateriasAsignadas()){
			Date fechaIni = matAsign.getCicloDeAsignacion().getFechaIni();
			Date fechaFin = matAsign.getCicloDeAsignacion().getFechaFin();
			if(fechaHoy.compareTo(fechaIni) >= 0 && fechaHoy.compareTo(fechaFin) <= 0){
				mat = matAsign.getMateria();
				break;
			}
		}
		return mat;
	}

}
