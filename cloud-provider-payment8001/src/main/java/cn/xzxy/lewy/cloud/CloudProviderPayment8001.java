package cn.xzxy.lewy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CloudProviderPayment8001 {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8001.class, args);
	}

}
