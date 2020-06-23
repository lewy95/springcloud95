package cn.xzxy.lewy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrder80Consul {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerOrder80Consul.class, args);
	}

}
