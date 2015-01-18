package com.blueskyconnie.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(JacksonFeature.class);
		register(PersonRest.class);
	}
}
