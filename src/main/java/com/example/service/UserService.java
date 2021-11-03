package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/25 4:04 下午
 */
public interface UserService extends IService<User> {
    User getOneByName(String name);
}
