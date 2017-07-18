package com.lh.web.util.common;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
public enum ResultEnum {
    UNKONWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    TOO_LITTLE(3, "密码少于3位，不够安全"),
    OSO_LITTLE(5, "密码少于5位，还是太短了");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
