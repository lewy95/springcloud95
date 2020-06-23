package cn.xzxy.lewy.cloud.dao;

import cn.xzxy.lewy.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
