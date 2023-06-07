package com.hfcsbc.client.command.credit;

import com.hfcsbc.constants.PayConstant;
import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Author: qdl
 * Email: 18919656953@163.com
 * Date: 2022/3/7
 * Description: 无感支付交易Cmd
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPayTradeCmd {

    /* *****************************************************************************************************************
     * 停车信息相关
     ******************************************************************************************************************/

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

    /**
     * 停车订单id
     */
    @NotNull(message = "停车订单id不可为空")
    private String osOrderId;

    /* *****************************************************************************************************************
     * 支付相关
     ******************************************************************************************************************/

    /**
     * 开放平台商户编号
     */
    @NotNull(message = "开放平台商户编号不能为空")
    private String osMerchantCode;

    /**
     * 开放平台门店编号
     */
    @NotNull(message = "门店编号不能为空")
    private String osStoreCode;

    /**
     * 支付业务,传入此值会进行校验,未指定时,不传
     */
    private String payBusiness;

    /**
     * 第三方商户创建的唯一订单号
     */
    private String ownerTradeNo;

    /**
     * 订单标题不能为空
     */
    @NotEmpty(message = "订单标题不能为空")
    private String title;

    /**
     * 订单总金额 单位分
     */
    @NotNull(message = "订单支付金额不能为空")
    private Integer orderFee;

    /**
     * 给支付平台的附加信息，支付平台会原封回调给对用方
     */
    private String remark;

    /**
     * 商户创建的订单业务号，商户自传，支付回调原封返回
     */
    private String ownerBusinessNo;

    /**
     * 商户支付终端，商户自传，支付回调原封返回
     */
    private String ownerPayTerminal;

    /**
     * 技术服务商id，该参数只有超级服务商使用
     */
    private Long superTePartnerId;
}
