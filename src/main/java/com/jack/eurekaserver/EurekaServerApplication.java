package com.jack.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jack
 *
 * http://localhost:7001/
 * http://localhost:7002/
 * http://localhost:7003/
 * add /etc/hosts
 * 127.0.0.1  http://eureka-7001.com
 * 127.0.0.1  http://eureka-7002.com
 * 127.0.0.1  http://eureka-7003.com
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
