package cn.xzxy.lewy.cloud.service.impl;

import cn.xzxy.lewy.cloud.dao.PaymentDao;
import cn.xzxy.lewy.cloud.entities.Payment;
import cn.xzxy.lewy.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
