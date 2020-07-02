package cn.xzxy.lewy.cloud.controller;

import cn.xzxy.lewy.cloud.entities.Payment;
import cn.xzxy.lewy.cloud.model.JsonResponseEntity;
import cn.xzxy.lewy.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String SERVER_PORT;

    @PostMapping("/insert")
    public JsonResponseEntity insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return JsonResponseEntity.buildOK("插入数据成功,serverport" + SERVER_PORT, payment);
        } else {
            return JsonResponseEntity.buildBusinessError("插入数据失败");
        }
    }

    @GetMapping("/get/{id}")
    public JsonResponseEntity getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("==============查询结果==============：" + payment);
        if (payment != null) {
            return JsonResponseEntity.buildOK("查询数据成功,serverport" + SERVER_PORT, payment);
        } else {
            return JsonResponseEntity.buildBusinessError("没有对应记录");
        }
    }

    /**
     * 测试服务发现
     */
    @GetMapping("/discovery")
    public void discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return SERVER_PORT;
    }
}
