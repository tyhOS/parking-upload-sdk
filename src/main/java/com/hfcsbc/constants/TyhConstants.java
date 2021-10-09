package com.hfcsbc.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: tyh-os
 * @description: 接入平台上传数据
 * @author: wangdan
 * @create: 2021-09-23 14:23
 **/
public class TyhConstants {
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface CarPlateColor {
        Integer BLUE = 1;   // 1：蓝色
        Integer YELLOW = 2; // 2：黄色
        Integer WHITE = 3;  // 3：白色
        Integer BLACK = 4;  // 4：黑色
        Integer GREEN = 5;  // 5：绿色
        Integer YELLOW_GREEN = 6; // 6：黄绿双拼色
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ParkType {
        Integer TEMPORARY = 1; // 临时车
        Integer MONTH  = 2;    // 包月车
        Integer PRIVILEGE = 3; // 特殊车
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface PayType {
        Integer CASH = 0;     // 现金
        Integer FREE  = 1;    // 免费
        Integer ALIPAY = 2;   // 支付宝
        Integer WEIXIN = 3;   // 微信
        Integer OTHER = -1;   // 其他
    }
    
}
