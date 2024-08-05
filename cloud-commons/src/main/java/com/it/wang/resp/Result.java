package com.it.wang.resp;

import com.it.wang.resp.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;
    private String massage;
    private T data;
    private long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMassage(ReturnCodeEnum.RC200.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(Integer code, String massage) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMassage(massage);
        result.setData(null);
        return result;
    }
}
