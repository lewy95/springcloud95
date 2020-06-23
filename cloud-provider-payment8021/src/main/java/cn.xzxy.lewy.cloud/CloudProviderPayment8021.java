package cn.xzxy.lewy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8021 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8021.class, args);
    }
}
