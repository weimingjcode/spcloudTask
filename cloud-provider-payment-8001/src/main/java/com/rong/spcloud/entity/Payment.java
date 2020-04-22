package com.rong.spcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 @author jm
 @DESCRIPTION 实体类
 @create 2020/4/21
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;

//    void connectMysql() {
//        String driverClassName = "com.mysql.jdbc.Driver";    //启动驱动
//        String url = "jdbc:mysql://47.104.133.140:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";    //设置连接路径
//        String username = "root";    //数据库用户名
//        String password = "1234";    //数据库连接密码
//        Connection con = null;        //连接
//        PreparedStatement pstmt = null;    //使用预编译语句
//        ResultSet rs = null;    //获取的结果集
//        try {
//            Class.forName(driverClassName); //执行驱动
//            con = DriverManager.getConnection(url, username, password); //获取连接
//
//
//            String sql = "SELECT * FROM payment"; //设置的预编译语句格式
//            pstmt = con.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            //关闭资源,倒关
//            try {
//                // 展开结果集数据库
//                while (rs.next()) {
//                    // 通过字段检索
//                    String name = rs.getString("serial");
//                    System.out.print(name);
//                }
//                if (rs != null) rs.close();
//                if (pstmt != null) pstmt.close();
//                if (con != null) con.close();  //必须要关
//            } catch (Exception e) {
//            }
//        }
//      }
//    public static void main(String[] args) {
//        new Payment().connectMysql();
//    }
}





