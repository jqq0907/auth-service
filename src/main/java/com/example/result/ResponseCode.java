package com.example.result;

import lombok.Getter;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/27 5:47 下午
 */
@Getter
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200, "请求成功"),
    FAIL(101,"请求失败");

    private final Integer code;
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
