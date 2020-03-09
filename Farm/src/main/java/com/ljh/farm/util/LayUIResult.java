package com.ljh.farm.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description
 * @Author ljh
 * @Date 2020/2/19 15:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LayUIResult {
    /**
     * 返回码
     **/
    private int code = 0;
    /**
     * 返回说明
     **/
    private String msg = "";
    /**
     * 条数
     **/
    private long count = 0;
    /**
     * 返回数据
     **/
    private Object data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date time = new Date();


    public LayUIResult() {
    }

    public LayUIResult(Object data) {
        this(0, "操作成功", data);
    }

    public LayUIResult(int code, String msg) {
        this(code, msg, null);
    }

    public LayUIResult(int code, String msg, Object data) {
        this(code, msg, 0, data);
    }

    public LayUIResult(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static LayUIResult error() {
        return new LayUIResult(1, "操作失败", null);
    }

    public static LayUIResult error(int code, String msg) {
        return new LayUIResult(code, msg, null);
    }

    public static LayUIResult error(String msg) {
        return error(1, msg);
    }


    public static LayUIResult ok() {
        return new LayUIResult(null);
    }

    public static LayUIResult ok(Object data) {
        return new LayUIResult(data);
    }

    public static LayUIResult ok(String msg) {
        return new LayUIResult(0, msg);
    }

    public static LayUIResult ok(String msg, Object data) {
        return new LayUIResult(0, msg, data);
    }
}
