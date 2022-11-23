package com.hfcsbc.client.dto;

import lombok.Data;

/**
 * @Author wangdong
 * @Date 2022/10/18
 * @Desc 查询APP跳转配置Dto
 */
@Data
public class AppPayJumpConfigDto {

    /**
     * 拉起的名称
     */
    private String name;

    /**
     * 拉起页面
     */
    private String path;

    /**
     * 拉起的页面类型
     */
    private String type;

}
