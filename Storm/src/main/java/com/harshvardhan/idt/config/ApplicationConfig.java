package com.harshvardhan.idt.config;

import java.util.logging.Level;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.models.Swagger;
import io.swagger.models.auth.BasicAuthDefinition;

@ApplicationPath("/rest/v1/*")
public class ApplicationConfig extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

	public ApplicationConfig() {
		logger.debug("Initializing Swagger");
		
		// Swagger Integration
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("Storm Weather App");
		beanConfig.setVersion("1.1.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/rest/v1");
		beanConfig.setResourcePackage("com.harshvardhan.idt");
		beanConfig.setScan(true);
		Swagger swagger = new Swagger();
		BasicAuthDefinition basicAuthDefinition = new BasicAuthDefinition();
		swagger.addSecurityDefinition("basicConfig", basicAuthDefinition);
		beanConfig.configure(swagger);
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		packages("com.harshvardhan.idt", "com.fasterxml.jackson");
		register(new LoggingFeature(java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 456789));
		// register(JacksonFeature.class);
		// register(HibernateAwareObjectMapper.class);

	}
}
