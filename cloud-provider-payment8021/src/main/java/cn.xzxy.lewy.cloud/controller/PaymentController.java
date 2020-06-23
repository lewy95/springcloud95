package cn.xzxy.lewy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping("/consul")
    public String paymentZK() {
        return "springCloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }
}
