package cn.xzxy.lewy.cloud.controller;

import cn.xzxy.lewy.cloud.entities.Payment;
import cn.xzxy.lewy.cloud.model.JsonResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderController {

    //private final static String PAYMENT_URL = "http://localhost:8001"; //单节点，可以直接写死
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 集群下，需要配置成服务名（针对Eureka）

    @Resource
    private RestTemplate restTemplate;
    //@Resource
    //private LoadBalancer loadBalancer;
    //@Resource
    //private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/get/{id}")
    public JsonResponseEntity getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, JsonResponseEntity.class, id);
    }

    @GetMapping("/consumer/payment/insert")
    public JsonResponseEntity create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResponseEntity.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public JsonResponseEntity getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<JsonResponseEntity> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, JsonResponseEntity.class, id);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return JsonResponseEntity.buildBusinessError("操作失败");
        }
    }

//    @GetMapping("/consumer/payment/createEntity")
//    public JsonResponseEntity<Payment> create2(Payment payment) {
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResponseEntity.class);
//    }
//
//    @GetMapping("/consumer/payment/lb")
//    public String getPaymentLB() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        if (instances == null || instances.size() <= 0) {
//            return null;
//        }
//
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//
//        return restTemplate.getForObject(uri + "/payment/lb", String.class);
//    }
//
//    @GetMapping("/consumer/payment/zipkin")
//    public String paymentZipkin() {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
//    }


}
