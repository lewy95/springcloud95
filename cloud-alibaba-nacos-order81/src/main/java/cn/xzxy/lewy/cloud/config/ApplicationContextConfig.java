package cn.xzxy.lewy.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ApplicationContextConfig {

    /**
     * 注入restTemplate，类似httpclient，用于实现模块间的远程调用
     */
    @Bean
    @LoadBalanced  // 如果要使用自定义的负载均衡策略（非ribbon提供）需要注释掉
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
