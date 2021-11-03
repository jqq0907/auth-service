package com.example.result;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangqiangqiang
 * @Description: 统一返回对象
 * @date 2021/10/27 5:43 下午
 */
@Data
@Builder
public class ResponseData<T extends Object> implements Serializable {

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 返回code
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 是否成功
     */
    private boolean success;

    public static ResponseData success() {
        return ResponseData.builder().code(ResponseCode.SUCCESS.getCode()).success(true).message(ResponseCode.SUCCESS.getMessage()).build();
    }

    public static ResponseData success(Object data) {
        return ResponseData.builder().code(ResponseCode.SUCCESS.getCode()).success(true).message(ResponseCode.SUCCESS.getMessage()).data(data).build();
    }

    public static ResponseData success(Integer code, String message, Object data) {
        return ResponseData.builder().code(code).success(true).message(message).data(data).build();
    }

    public static ResponseData success(ResponseCode responseCode, Object data) {
        return ResponseData.builder().code(responseCode.getCode()).success(true).message(responseCode.getMessage()).data(data).build();
    }

    public static ResponseData fali(ResponseCode responseCode, Object data) {
        return ResponseData.builder().code(responseCode.getCode()).success(false).message(responseCode.getMessage()).data(data).build();
    }

    public static ResponseData fali(Integer code, String message, Object data) {
        return ResponseData.builder().code(code).success(false).message(message).data(data).build();
    }

    public static ResponseData ofResponse(boolean success) {
        if (success) {
            return ResponseData.builder().code(ResponseCode.SUCCESS.getCode()).success(true).message(ResponseCode.SUCCESS.getMessage()).build();
        } else {
            return ResponseData.builder().code(ResponseCode.SUCCESS.getCode()).success(false).message(ResponseCode.SUCCESS.getMessage()).build();
        }
    }
}
