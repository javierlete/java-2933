package com.uberits.rest.v3;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api/v3")
public class AplicacionRest extends ResourceConfig {

    public AplicacionRest() {
        packages("com.uberits.rest.v3");
        register(JacksonConfig.class);
    }
}