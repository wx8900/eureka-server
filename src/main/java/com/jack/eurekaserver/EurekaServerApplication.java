package com.jack.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jack
 *
 * 创建基于Eureka的服务注册中心 Server端
 *
 * http://localhost:7001/
 * http://localhost:7002/
 * http://localhost:7003/
 *
 * add /etc/hosts
 * 127.0.0.1 eureka-7001.com
 * 127.0.0.1 eureka-7002.com
 * 127.0.0.1 eureka-7003.com
 * 127.0.0.1 eureka-7004.com
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
