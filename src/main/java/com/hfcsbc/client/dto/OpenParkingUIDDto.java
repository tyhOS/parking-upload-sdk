package com.hfcsbc.client.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/9
 * @description 对账下载orderId
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenParkingUIDDto {

    private List<String> orderIdList;

}
