package com.lh.web.util.common;

import lombok.Data;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
@Data
public class WebException extends RuntimeException {
    private Integer code;

    public WebException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
