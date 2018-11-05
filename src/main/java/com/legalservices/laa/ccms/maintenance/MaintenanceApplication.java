package com.legalservices.laa.ccms.maintenance;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles ;
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* weblogic additions */
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/* weblogic security issue */
/* import org.springframework.web.WebApplicationInitializer; implements WebApplicationInitializer */
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication 
public class MaintenanceApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	
/*	private static final Logger logger = LoggerFactory.getLogger( BetaLanding2Application.class );   
*/

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources( MaintenanceApplication.class);
	}	
	
	public static void main(String[] args) {
		SpringApplication.run( MaintenanceApplication.class, args);
	}
  
	
}