package com.flowable.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final int OK_CODE = 200;

    private static final int FAIl_CODE = 500;

    private Integer code = 0;

    private boolean success;

    private String msg;

    private T data;

    public Result(int code, T data, String msg) {
        this.code = code;
        this.success = code == OK_CODE;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this(code, null, msg);
    }

    /**
     * 成功返回
     *
     * @param <T>  泛型
     * @return ResultVO
     */
    public static <T> Result<T> success() {
        return success(OK_CODE, null, "操作成功");
    }


    /**
     * 成功返回
     *
     * @param data 返回数据
     * @param msg  消息
     * @param <T>  泛型
     * @return ResultVO
     */
    public static <T> Result<T> success(String msg, T data) {
        return success(OK_CODE, data, msg);
    }

    /**
     * 成功返回
     *
     * @param msg 消息
     * @param <T> 泛型
     * @return ResultVO
     */
    public static <T> Result<T> success(String msg) {
        return success(OK_CODE, null, msg);
    }

    /**
     * 成功返回
     *
     * @param data 返回数据
     * @param <T>  泛型
     * @return ResultVO
     */
    public static <T> Result<T> success(T data) {
        return success(OK_CODE, data,"操作成功");
    }

    /**
     * 成功返回全参
     *
     * @param code 状态码
     * @param data 返回数据
     * @param msg  消息
     * @param <T>  泛型
     * @return ResultVO
     */
    public static <T> Result<T> success(int code, T data, String msg) {
        return new Result<>(code, data, msg);
    }


    /**
     * 异常返回
     *
     * @param msg 消息
     * @return ResultVO
     */
    public static <T> Result<T> fail(String msg) {
        return fail(FAIl_CODE, msg);
    }


    /**
     * 失败返回全参
     *
     * @param code 状态码
     * @param msg  消息
     * @return ResultVO
     */
    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg);
    }
}
