package com.hfcsbc.client.command.credit;

import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Author: qdl
 * Email: 18919656953@163.com
 * Date: 2022/3/10
 * Description: 车辆无感支付是否可用
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPayCarStatusCmd {

    /**
     * 车牌号
     */
    @NotNull(message = "车牌号不可为空")
    private String carPlate;

    /**
     * 车牌颜色
     */
    @NotNull(message = "车牌颜色不可为空")
    @TyhConstants.CarPlateColor
    private Integer carPlateColor;

}
