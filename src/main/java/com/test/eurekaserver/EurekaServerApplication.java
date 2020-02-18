package com.test.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jack
 *
 * 创建基于Eureka的服务注册中心 Server端
 * Exception:
 * c.n.e.registry.AbstractInstanceRegistry  : Registered instance SERVICE_PROVIDER/192.168.11.38:service_provider:8001 with status UP (replication=false)
 * 2020-02-12 00:25:31.596 ERROR 11654 --- [reka-7003.com-4] c.n.e.cluster.ReplicationTaskProcessor   : It seems to be a socket read timeout exception, it will retry later. if it continues to happen and some eureka node occupied all the cpu time, you should set property 'eureka.server.peer-node-read-timeout-ms' to a bigger value
 * com.sun.jersey.api.client.ClientHandlerException: java.net.SocketTimeoutException: Read timed out
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
 *
 * http://localhost:7001/
 * Instances currently registered with Eureka
 * Application	AMIs	Availability Zones	Status
 * FEIGN-CONSUMER	n/a (1)	(1)	UP (1) - 192.168.11.38:feign-consumer:9001
 * SERVICE-CONSUMER	n/a (1)	(1)	DOWN (1) - 192.168.11.38:service-consumer:9001
 * SERVICE-PROVIDER	n/a (1)	(1)	UP (1) - 192.168.11.38:service-provider:8001
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
