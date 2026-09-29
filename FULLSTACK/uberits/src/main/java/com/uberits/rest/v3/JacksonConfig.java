package com.uberits.rest.v3;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JacksonConfig extends ResourceConfig {

	public JacksonConfig() {
		register(JacksonFeature.class);
	}
}