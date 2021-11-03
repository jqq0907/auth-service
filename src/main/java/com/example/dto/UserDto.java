package com.example.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/28 5:04 下午
 */
@Data
public class UserDto implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户code，数据权限
     */
    private String userCode;

    /**
     * 账户名
     */
    private String username;

    /**
     * 账户密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 性别，默认男
     */
    private String gender;

    /**
     * 头像
     */
    private String profilePhoto;

    /**
     * 头像地址
     */
    private String profilePhotoSrc;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 城市
     */
    private String city;

    /**
     * 状态，1启用，0禁用，默认true
     */
    private Boolean userEnabled;

    /**
     * 是否是系统管理员admin,默认false
     */
    private Boolean idAdmin = false;

    /**
     * 最后一次修改密码时间
     */
    private LocalDateTime pwdResetTime;

    /**
     * 部门code，数据权限
     */
    private String departmentCode;

}
