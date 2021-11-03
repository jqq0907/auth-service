package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Role;

import java.util.Set;

/**  
    * @Description: 
    * @author jiangqiangqiang
    * @date 2021/10/25 5:34 下午
    */
public interface RoleMapper extends BaseMapper<Role> {
      Set<Role> selectListByUserId(Long userId);
  }