package com.rong.spcloud.service;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/21
*/

import com.rong.spcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int creatPayment(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
