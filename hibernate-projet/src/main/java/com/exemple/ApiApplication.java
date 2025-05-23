package com.exemple;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApiApplication extends ResourceConfig {
    public ApiApplication() {
        packages("com.exemple.resources");
        register(JacksonFeature.class);
    }
} 