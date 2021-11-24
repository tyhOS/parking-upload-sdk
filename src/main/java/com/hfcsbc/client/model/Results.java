package com.hfcsbc.client.model;

import com.alibaba.fastjson.JSON;
import com.hfcsbc.constants.Code;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @program: tyh-os
 * @description: 响应标准封装
 * @author: wangdan
 * @create: 2021-09-23 16:11
 **/
@Getter
@NoArgsConstructor
public class Results<T> {
    private int code;
    private String msg;
    private T data;
    private Object error;

    private Results(Code c) {
        this.code = c.getBCode();
        this.msg = c.getMsg();
    }

    private Results(Code c, String msg, T data) {
        this.code = c.getBCode();
        this.msg = msg;
        this.data = data;
    }

    private Results(Code c, String msg, T data, Object error) {
        this.code = c.getBCode();
        this.msg = msg;
        this.data = data;
        this.error = error;
    }

    private Results(Code c, T data) {
        this(c);
        this.data = data;
    }

    public static <T> Results<T> success(T data) {
        return new Results<T>(Code.SUCCESS, data);
    }

    public static <T> Results<T> success() {
        return success(null);
    }

    public static <T> Results<String> successJsonData(T data) {
        return Results.success(JSON.toJSONString(data));
    }

    public static <T> Results<T> failure(T data, String msg) {
        return new Results<T>(Code.FAILURE, msg, data);
    }

    public static <T> Results<T> failure(T data) {
        return new Results<T>(Code.FAILURE, data);
    }

    public static <T> Results<T> failureNoData(String msg) {
        return failure(null, msg);
    }

    public static <T> Results<T> failure() {
        return failure(null);
    }

    public static <T> Results<T> errNotFound(T data, String msg) {
        return new Results<T>(Code.ITEM_NOT_FOUND, msg, data);
    }

    public static <T> Results<T> errNotFound(T data) {
        return new Results<T>(Code.ITEM_NOT_FOUND, data);
    }

    public static <T> Results<T> errNotFoundNoData(String msg) {
        return errNotFound(null, msg);
    }

    public static <T> Results<T> errNotFound() {
        return errNotFound(null);
    }

    public static <T> Results<T> errConflict(T data, String msg) {
        return new Results<T>(Code.ITEM_CONFLICT, msg, data);
    }

    public static <T> Results<T> errConflict(T data) {
        return new Results<T>(Code.ITEM_CONFLICT, data);
    }

    public static <T> Results<T> errConflictNoData(String msg) {
        return errConflict(null, msg);
    }

    public static <T> Results<T> errConflict() {
        return errConflict(null);
    }

    public static <T> Results<T> errInternalServer(T data, String msg) {
        return new Results<T>(Code.INTERNAL_SERVER, msg, data);
    }

    public static <T> Results<T> errInternalServer(T data) {
        return new Results<T>(Code.INTERNAL_SERVER, data);
    }

    public static <T> Results<T> errInternalServerNoData(String msg) {
        return errInternalServer(null, msg);
    }

    public static <T> Results<T> errInternalServer() {
        return errInternalServer(null);
    }

    public static Results exception(Code code) {
        return new Results(code);
    }

    public static <T> Results<T> exception(Code code, T data) {
        return new Results(code, data);
    }

    public static <T> Results<T> exception(Code c, String msg, T data) {
        return new Results<>(c, msg, data);
    }

    public static Results error(Code code) {
        return new Results(code);
    }

    public static <T> Results<T> error(Code code, Object error) {
        return new Results(code, code.getMsg(), null, error);
    }

    public static <T> Results<T> error(Code c, String msg, Object error) {
        return new Results<>(c, msg, null, error);
    }

    public static <T> Results<T> error(Code c, String msg, T data, Object error) {
        return new Results<>(c, msg, data, error);
    }


    public boolean ifSuccess() {
        return Code.SUCCESS.getBCode() == this.getCode();
    }
}

