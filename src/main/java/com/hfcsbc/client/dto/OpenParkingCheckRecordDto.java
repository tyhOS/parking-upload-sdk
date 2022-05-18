package com.hfcsbc.client.dto;

import com.hfcsbc.constants.TyhConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/8
 * @description 对账日返回对账标致
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenParkingCheckRecordDto {

    @TyhConstants.CheckRecordFlag
    private Integer driveInFlag;

    @TyhConstants.CheckRecordFlag
    private Integer driveOutFlag;

}
