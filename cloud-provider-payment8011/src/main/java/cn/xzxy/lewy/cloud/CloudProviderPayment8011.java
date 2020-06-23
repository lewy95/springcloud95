package cn.xzxy.lewy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudProviderPayment8011 {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8011.class, args);
	}

}
