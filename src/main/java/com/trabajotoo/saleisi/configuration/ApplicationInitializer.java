/**
 * Clase en la cual se registran todas las clases de configuracion del sistema:
 * SpringSecurity, Hibernate, SpringMVC, etc; para ser inicializados posteriormente
 * al momento de correr la aplicacion en el server
 */

package com.trabajotoo.saleisi.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.trabajotoo.saleisi.configuration.RootContext;
import com.trabajotoo.saleisi.configuration.WebConfiguration;

public class ApplicationInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
	
	// Metodo en el cual se registran las clases de configuracion que tiene que ver con
	// otros componentes de Spring aparte de Spring MVC (SpringSecurity, SpringSession, etc) 
	// y otras clases de configuracion compartidas por todos los componentes 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootContext.class, SpringSecurityConfig.class};
	}

	// Metodo en el cual se registra la configuracion de SpringMVC
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfiguration.class };
	}

	// Metodo en el cual se registra/an el/los DispatcherServlet y las direcciones 
	// que seran manejadas
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
