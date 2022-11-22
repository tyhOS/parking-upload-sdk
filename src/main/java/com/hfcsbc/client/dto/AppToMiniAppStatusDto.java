package com.hfcsbc.client.dto;

import lombok.Data;

/**
 * @Author wangdong
 * @Date 2022/10/18
 * @Desc 查询APP跳转小程序状态Dto
 */
@Data
public class AppToMiniAppStatusDto {

    /**
     * 拉起的小程序的username
     */
    private String miniAppName;

    /**
     * 拉起小程序页面
     */
    private String miniAppPath;

}
