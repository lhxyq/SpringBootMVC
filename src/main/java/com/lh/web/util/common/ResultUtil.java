package com.lh.web.util.common;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMag("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMag(msg);
        return result;
    }
}
