package com.hfcsbc.client.dto;

import lombok.*;

import java.util.Map;

/**
 * @Author: HeQuanChao
 * @Date: 22/04/13
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class OpenParkingDockingStatusDto {

	private Map<String,Integer> parkingStatusMap;
}
