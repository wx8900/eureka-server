package com.test.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jack
 *
 * Eureka实例：表示启动的Eureka Server项目。
 * peer：同伴，Eureka集群中所有Eureka实例之间互称peer。
 * replica：副本，由于Eureka集群中的Eureka实例之间相互同步注册信息，Eureka实例称其他Eureka实例为自己的replica
 *
 * 创建基于Eureka的服务注册中心 Server端
 * Exception:
 * c.n.e.registry.AbstractInstanceRegistry  : Registered instance SERVICE_PROVIDER/192.168.11.38:service_provider:8001 with status UP (replication=false)
 * 2020-02-12 00:25:31.596 ERROR 11654 --- [reka-7003.com-4] c.n.e.cluster.ReplicationTaskProcessor   : It seems to be a socket read timeout exception, it will retry later. if it continues to happen and some eureka node occupied all the cpu time, you should set property 'eureka.server.peer-node-read-timeout-ms' to a bigger value
 * com.sun.jersey.api.client.ClientHandlerException: java.net.SocketTimeoutException: Read timed out
 *
 * Below exception is OK.
 * com.sun.jersey.api.client.ClientHandlerException: java.net.ConnectException: Connection refused (Connection refused)
 *
 *
 *  Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://eureka-7001.com:7001/eureka/}
 *
 * http://localhost:7001/
 * http://localhost:7002/
 * http://localhost:7003/
 *
 * add /etc/hosts
 * sudo vi /etc/host
 * 127.0.0.1 eureka-7001.com
 * 127.0.0.1 eureka-7002.com
 * 127.0.0.1 eureka-7003.com
 *
 * http://localhost:7001/
 * Instances currently registered with Eureka
 * Application	AMIs	Availability Zones	Status
 * FEIGN-CONSUMER	n/a (1)	(1)	UP (1) - 192.168.11.38:feign-consumer:9001
 * SERVICE-CONSUMER	n/a (1)	(1)	DOWN (1) - 192.168.11.38:service-consumer:9001
 * SERVICE-PROVIDER	n/a (1)	(1)	UP (1) - 192.168.11.38:service-provider:8001
 *
 * http://localhost:7003/
 * Application	AMIs	Availability Zones	Status
 * FEIGN-CONSUMER	n/a (2)	(2)	UP (2) - 192.168.11.38:feign-consumer:9001 , 192.168.11.38:feign-consumer:9002
 * SERVICE-PROVIDER	n/a (2)	(2)	UP (2) - 192.168.11.38:service-provider:8001 , 192.168.11.38:service-provider:8002
 *
 *  solve unavailable-replicas problem:
 *  (1) each node of application name in three properties file are same(spring.application.name are same)
 *  (2) 本地测试时, 各节点都在同一台机器，hostname需要在本地host中填写，各个节点使用自己的host
 *  (3) prefer-ip-address设置为true或默认不填写
 *  (4) The value of register-with-eureka and fetch-registry are all ture(or delete them in properties files,default is true)
 *  (5) defaultZone不能使用localhost，需要使用自己在host中配置的域名，配置项为除自己以外的集群中所有节点
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
