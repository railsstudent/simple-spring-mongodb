package com.blueskyconnie.configuration;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blueskyconnie.rest.JerseyConfig;

@Configuration
public class WebServletConfig extends SpringBootServletInitializer {

	@Bean
	public ServletRegistrationBean jerseyServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new ServletContainer(new JerseyConfig()), "/app/*");
		registration.setLoadOnStartup(1);
		registration.setName("jerseyServlet");
		return registration;
	}	
}
