package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerDemoApplication {

	/**
	 * Config Server
	 * 1. Create a spring boot project with only 1 dependency
	 * cloud coonfig server
	 * 2. Add @EnableConfigServer on the class with main method
	 * 3. configure properties file for git repo and server port
	 *  server.port=8888
		spring.cloud.config.server.git.uri=https://github.com/shalini06mittal/CloudConfigRepo.git
		4. start the server and access the properties from different files as follows
		http://localhost:8888/config-server-client/production
		http://localhost:8888/config-server-client/default
		http://localhost:8888/config-server-client/development
		
		
		Config Client
		1. Create a spring boot project with foll dependencies
		config client
		web, actuator, devtools
		2. Configure properties file for referring it to config server
		
			spring.application.name=config-server-client
			server.port=8081
			#spring.cloud.config.uri=http://localhost:8888 - old versions
			
			spring.config.import=optional:configserver:http://localhost:8888/
			
			#spring.cloud.config.name=config-server-client
			
			management.endpoints.web.exposure.include=*
			
			spring.profiles.active=production
			
			spring application name and properties filename should be same for it to pick from 
			default properties filename
		3. create a rest controller to read the properties from git repo
		4. if any changes in the git repo then have to manually refresh the client
		making a POST request to http://localhost:8081/actuator/refresh
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerDemoApplication.class, args);
	}

}
