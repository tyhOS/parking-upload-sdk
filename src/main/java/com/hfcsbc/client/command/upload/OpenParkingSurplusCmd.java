package com.hfcsbc.client.command.upload;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: tyh-os
 * @description: 2.2.1停车场余位上传
 * @author: wangdan
 * @create: 2021-09-24 16:13
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingSurplusCmd {

    @NotNull(message = "osStoreId不可为空")
    private Long osStoreId;

    @NotNull(message = "total不可为空")
    private Integer total;

    @NotNull(message = "surplus不可为空")
    private Integer surplus;
}
