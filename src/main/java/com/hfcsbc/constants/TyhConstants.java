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
    public @interface CarPlateColorDesc {
        String BLUE = "蓝色";
        String YELLOW = "黄色";
        String WHITE = "白色";
        String BLACK = "黑色";
        String GREEN = "绿色";
        String YELLOW_GREEN = "黄绿双拼色";
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
    public @interface ParkTypeDesc {
        String TEMPORARY = "临时车";
        String MONTH  = "包月车";
        String PRIVILEGE = "特殊车";
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

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface CheckRecordFlag {
        Integer PASS   = 0;       // 帐平
        Integer NO_PASS  = 1;     // 帐不平
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface DriveType {
        Integer DRIVE_IN   = 0;     // 驶入
        Integer DRIVE_OUT  = 1;     // 驶出
    }

    /**
     * 停车订单图片来源 1：上传驶入照片；2：上传驶出照片；3：上传车位监控照片；4：上传车道监控抓拍图片;
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ImageSource {
        Integer DRIVE_IN = 1;               //驶入照片
        Integer DRIVE_OUT = 2;              //驶出照片
        Integer PARKING_SPACE = 3;          //车位监控照片
        Integer PASSAGE = 4;                //车道监控抓拍
    }

    /**
     * 图片上传类型
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface ImageType {
        Integer URL = 1;            //URL链接
        Integer BASE64 = 2;         //Base64文件
    }

    public static String getCarPlateColorDesc(@TyhConstants.CarPlateColor Integer carPlateColor) {
        if (CarPlateColor.BLUE.equals(carPlateColor)) return CarPlateColorDesc.BLUE;
        else if (CarPlateColor.YELLOW.equals(carPlateColor)) return CarPlateColorDesc.YELLOW;
        else if (CarPlateColor.WHITE.equals(carPlateColor)) return CarPlateColorDesc.WHITE;
        else if (CarPlateColor.BLACK.equals(carPlateColor)) return CarPlateColorDesc.BLACK;
        else if (CarPlateColor.GREEN.equals(carPlateColor)) return CarPlateColorDesc.GREEN;
        else if (CarPlateColor.YELLOW_GREEN.equals(carPlateColor)) return CarPlateColorDesc.YELLOW_GREEN;
        return "";
    }

}
