package com.hfcsbc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangdong
 * @dateTime 2022/3/28
 * @description 分页工具
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    /**
     * 当前页
     */
    private int number;
    /**
     * 每页数量
     */
    private int size;

    private int numberOfElements;
    /**
     * 是否第一页
     */
    private boolean first;
    /**
     * 是否最后一页
     */
    private boolean last;
    /**
     * 总数量
     */
    private Long totalElements;
    /**
     * 总页数
     */
    private Integer totalPages;

    private List<T> content;
}
