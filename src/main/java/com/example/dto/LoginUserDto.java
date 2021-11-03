package com.example.dto;

import lombok.Data;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/28 5:04 下午
 */
@Data
public class LoginUserDto {
    /**
     * 账户名
     */
    private String username;

    /**
     * 账户密码
     */
    private String password;
}
