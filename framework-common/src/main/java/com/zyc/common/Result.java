package com.zyc.common;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Result<T> {

    private int status;

    private String message;

    private T data;

    private String timestamp;

    public Result (){
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static <T> Result<T> success() {
        Result<T> Result = new Result<>();
        Result.setStatus(ReturnCode.RC100.getCode());
        Result.setMessage(ReturnCode.RC100.getMessage());
        return Result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> Result = new Result<>();
        Result.setStatus(ReturnCode.RC100.getCode());
        Result.setMessage(ReturnCode.RC100.getMessage());
        Result.setData(data);
        return Result;
    }

    public static <T> Result<T> fail(int code, String message) {
        Result<T> Result = new Result<>();
        Result.setStatus(code);
        Result.setMessage(message);
        return Result;
    }

}
