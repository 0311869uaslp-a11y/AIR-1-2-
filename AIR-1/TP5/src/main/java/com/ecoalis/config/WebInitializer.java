package com.ecoalis.config;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


public class WebInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";
    
    private static final String CHARACTER_ENCODING = "UTF-8";
    
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MvcConfiguration.class);
		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
		servlet.addMapping(DISPATCHER_SERVLET_MAPPING);
		servlet.setLoadOnStartup(1);
		
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(CHARACTER_ENCODING);
        characterEncodingFilter.setForceEncoding(true);
        
		servletContext.addListener(new ContextLoaderListener(rootContext));
        
	}

}