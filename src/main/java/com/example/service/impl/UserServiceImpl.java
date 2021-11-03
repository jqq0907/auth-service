package com.example.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/25 4:04 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getOneByName(String name) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, name));
    }
}
