package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @program: tyh-os
 * @description: 2.2.1停车场余位上传
 * @author: wangdan
 * @create: 2021-09-24 16:13
 **/
@Data
public class UploadSurplusCmd {
    @JSONField(name = "parking_code")
    private String parkingCode;
    private Integer total;
    private Integer surplus;
}
