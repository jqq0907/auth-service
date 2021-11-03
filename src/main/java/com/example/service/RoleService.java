package com.example.service;

import com.example.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**  
    * @Description: 
    * @author jiangqiangqiang
    * @date 2021/10/25 5:34 下午
    */
public interface RoleService extends IService<Role>{


          Set<Role> listByUserId(Long userId);
      }
