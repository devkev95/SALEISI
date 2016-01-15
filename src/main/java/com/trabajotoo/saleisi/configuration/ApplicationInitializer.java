package com.trabajotoo.saleisi.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.trabajotoo.saleisi.configuration.RootContext;
import com.trabajotoo.saleisi.configuration.WebConfiguration;

public class ApplicationInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
	
@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[] { RootContext.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
	return new Class[] { WebConfiguration.class };
}

@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}

}
