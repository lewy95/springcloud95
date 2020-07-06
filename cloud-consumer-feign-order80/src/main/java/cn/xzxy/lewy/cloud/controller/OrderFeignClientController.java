package cn.xzxy.lewy.cloud.controller;

import cn.xzxy.lewy.cloud.model.JsonResponseEntity;
import cn.xzxy.lewy.cloud.servcie.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 根据id查询
     */
    @GetMapping(value = "/payment/get/{id}")
    public JsonResponseEntity getPaymentById(@PathVariable("id") Long id) {
        return JsonResponseEntity.buildOK(paymentFeignService.getPaymentById(id));
    }

    /**
     * 模拟feign超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
