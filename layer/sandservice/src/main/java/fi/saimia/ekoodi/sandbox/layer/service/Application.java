package fi.saimia.ekoodi.sandbox.layer.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class Application extends SpringBootServletInitializer {
	private static final Log LOG = LogFactory.getLog(Application.class); 
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	LOG.info("Application Initialized");
        return application.sources(Application.class);
    }
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}	

}
