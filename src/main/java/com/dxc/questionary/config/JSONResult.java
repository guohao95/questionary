package com.dxc.questionary.config;

import com.dxc.questionary.config.constant.Constant;
import lombok.Data;

@Data
public class JSONResult<T> {
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;

    public static <T> JSONResult<T> OK(){
        JSONResult res = new JSONResult();
        res.code = Constant.HTTP_STATUS_OK;
        res.message = Constant.OPERATION_SUCCESS;
        res.data = null;
        res.timestamp = System.currentTimeMillis();
        return res;
    }

    public static <T> JSONResult<T> Error(){
        JSONResult res = new JSONResult();
        res.code = Constant.HTTP_STATUS_ERROR;
        res.message = Constant.OPERATION_ERROR;
        res.data = null;
        res.timestamp = System.currentTimeMillis();
        return res;
    }

    public static <T>JSONResult<T> Ok(String message, T data){
        JSONResult res = new JSONResult();
        res.code = Constant.HTTP_STATUS_OK;
        res.message = message;
        res.data = data;
        res.timestamp = System.currentTimeMillis();
        return res;
    }

    public static <T>JSONResult<T> Failed(String message, T data){
        JSONResult res = new JSONResult();
        res.code = Constant.HTTP_STATUS_ERROR;
        res.message = message;
        res.data = data;
        res.timestamp = System.currentTimeMillis();
        return res;
    }
}
