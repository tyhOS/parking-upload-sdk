package com.hfcsbc.client.command.upload;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Author: qdl
 * Email: 18919656953@163.com
 * Date: 2022/3/9
 * Description: 无感支付启用/停用cmd
 */
@Data
public class OpenParkingCreditPayCmd {

    /**
     * 门店id
     */
    @NotNull(message = "门店id不可为空")
    private Long osStoreId;

    /**
     * 是否启用无感支付 0停用 1启用
     */
    @NotNull(message = "是否启用无感支付不可为空")
    private Integer status;

}
