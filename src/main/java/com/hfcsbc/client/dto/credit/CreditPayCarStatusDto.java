package com.hfcsbc.client.dto.credit;

import lombok.Data;

/**
 * Author: qdl
 * Email: 18919656953@163.com
 * Date: 2022/3/10
 * Description: 车牌无感支付可用状态
 */
@Data
public class CreditPayCarStatusDto {

    /**
     * 可用状态 1可用 0不可用
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String subMessage;

}
