package cn.xzxy.lewy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudProviderPayment8002 {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8002.class, args);
	}

}
