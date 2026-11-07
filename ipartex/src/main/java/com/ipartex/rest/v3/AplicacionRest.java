package com.ipartex.rest.v3;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/v3")
public class AplicacionRest extends ResourceConfig {
	public AplicacionRest() {
		packages("com.ipartex");
		register(JacksonConfig.class);
	}
}
