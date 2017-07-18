package com.lh.web.handle;

import com.lh.web.util.common.Result;
import com.lh.web.util.common.ResultEnum;
import com.lh.web.util.common.ResultUtil;
import com.lh.web.util.common.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof WebException)
            return ResultUtil.fail(((WebException) e).getCode(), e.getMessage());
        logger.error("【系统异常】{}", e);
        return ResultUtil.fail(ResultEnum.UNKONWN_ERROR.getCode(), ResultEnum.UNKONWN_ERROR.getMsg());
    }
}
