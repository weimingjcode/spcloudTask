package com.rong.spcloud.dao;
/*
 @author jm
 @DESCRIPTION 数据库读写接口
 @create 2020/4/21
*/

import com.rong.spcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentDao {
    public int creatPayment(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
