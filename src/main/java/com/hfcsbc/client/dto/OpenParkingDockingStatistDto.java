package com.hfcsbc.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: HeQuanChao
 * @Date: 22/04/07
 * @Description 开发平台 停车数据接入异常判定统计结果
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDockingStatistDto implements Serializable {

	private Long dockingNum;

	private Long onLineNum;

	private Long offLineNum;
}
