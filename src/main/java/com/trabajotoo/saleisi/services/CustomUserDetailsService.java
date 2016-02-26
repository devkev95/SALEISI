package com.trabajotoo.saleisi.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.trabajotoo.saleisi.model.RolAsignado;
import com.trabajotoo.saleisi.model.Usuario;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioService userService;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws 
	UsernameNotFoundException {
		Usuario user = userService.findByUsername(userName);
		if (user == null){
			System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
		}
		
		return new User(user.getNomUsuario(), user.getPassword(), user.isEstado(),
				true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Usuario user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(RolAsignado rolAsign: user.getRolesAsignados()){
			if (rolAsign.isEstado()){
				authorities.add(new SimpleGrantedAuthority("ROLE_"+
			rolAsign.getRol().getCodigo()));
				break;
			}
		}
		
		return authorities;
	}
	

}