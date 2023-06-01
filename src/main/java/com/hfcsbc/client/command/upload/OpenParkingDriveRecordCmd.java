package com.hfcsbc.client.command.upload;

import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: HeQuanChao
 * @Date: 22/04/08
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDriveRecordCmd {

	/**
	 * 停车场号即门店号
	 */
    private String osStoreCode;

	/**
	 * 订单归属商户号
	 */
	private Long osMerchantId;

	/**
	 * 订单归属服务商号
	 */
	private Long osPartnerId;

	/**
	 * 订单记录号
	 */
	private String orderId;

	/**
	 * 车牌号
	 */
	private String carPlate;

	/**
	 * 车牌颜色
	 */
	@TyhConstants.CarPlateColor
	private Integer carPlateColor;

	/**
	 * 停车类型 1：临时车；2：包月车；3：特殊车
	 */
	private Integer parkingType;

	/**
	 * 驶入开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date inStartDate;

	/**
	 * 驶入结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date inEndDate;

	/**
	 * 驶出开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date outStartDate;

	/**
	 * 驶出结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date outEndDate;

	/**
	 * 在停状态 0在停 1已完成
	 */
	private Integer status;

	/**
	 * 当前页
	 */
	private Integer page = 0;

	/**
	 * 每页查询数
	 */
	private Integer size = 20;

}
