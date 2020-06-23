package cn.xzxy.lewy.cloud.service;

import cn.xzxy.lewy.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {
    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
