package de.fmp.spring.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import de.fmp.spring.config.WebApplicationContextConfig;



public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
				WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	
}
