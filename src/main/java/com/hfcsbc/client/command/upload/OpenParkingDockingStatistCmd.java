package com.hfcsbc.client.command.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author: HeQuanChao
 * @Date: 22/04/07
 * @Description
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenParkingDockingStatistCmd {

	@NotNull(message = "queryDate不可为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date queryDate;

	/** 需要查询的停车场id数组 */
	private List<Long> osStoreIds;
}
