package com.hfcsbc.client.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2021/11/9
 * @description 对账下载orderId
 */
@Data
@Builder
public class UploadUIDDto  {

    private List<String> orderIdList;

}
