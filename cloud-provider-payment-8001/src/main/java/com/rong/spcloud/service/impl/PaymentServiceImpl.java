package com.rong.spcloud.service.impl;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/21
*/

import com.rong.spcloud.dao.PaymentDao;
import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    PaymentDao paymentDao;

    public int creatPayment(Payment payment){
        return paymentDao.creatPayment(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
