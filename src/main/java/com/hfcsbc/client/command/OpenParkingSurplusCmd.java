package com.hfcsbc.client.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tyh-os
 * @description: 2.2.1停车场余位上传
 * @author: wangdan
 * @create: 2021-09-24 16:13
 **/
@Data
@Builder
public class OpenParkingSurplusCmd {

    @JSONField(name = "os_store_id")
    @NotNull(message = "os_store_id不可为空")
    private Long osStoreId;

    @NotNull(message = "total不可为空")
    private Integer total;

    @NotNull(message = "surplus不可为空")
    private Integer surplus;
}
