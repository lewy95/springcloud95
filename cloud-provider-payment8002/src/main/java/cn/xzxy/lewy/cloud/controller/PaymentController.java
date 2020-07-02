package cn.xzxy.lewy.cloud.controller;

import cn.xzxy.lewy.cloud.entities.Payment;
import cn.xzxy.lewy.cloud.model.JsonResponseEntity;
import cn.xzxy.lewy.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

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

    @GetMapping("/lb")
    public String getPaymentLB() {
        return SERVER_PORT;
    }
}
