package com.rong.spcloud.entity.deal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 @author jm
 @DESCRIPTION 返回前段的通用type
 @create 2020/4/21
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T      data;

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
