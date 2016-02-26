package com.trabajotoo.saleisi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException{
		String targetURL = determineTargetURL(authentication);
		if (response.isCommitted()){
			 System.out.println("Can't redirect");
	         return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetURL);
	}

	/**
     * This method extracts the roles of currently logged-in user and returns
     * an appropiated URL dependig of the user role
     **/
	private String determineTargetURL(Authentication authentication) {
		String url = "";
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		
		for(GrantedAuthority a : authorities){
			roles.add(a.getAuthority());
		}
		
		if (roles.contains("ROLE_ADMIN")){
			url = "/admin";
		}
		else if (roles.contains("ROLE_COORD")){
			url = "/coordinador";
		}
		else if (roles.contains("ROLE_DIR")){
			url = "/director";
		}
		else{
			url = null;
		}
		return url;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
 
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}
