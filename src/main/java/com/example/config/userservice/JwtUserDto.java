package com.example.config.userservice;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author jiangqiangqiang
 * @Description:
 * @date 2021/10/25 3:33 下午
 */
@Data
@Builder
public class JwtUserDto implements UserDetails, Serializable {
    private UserDto userDto;
    private List<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    @JSONField(serialize = false)
    @Override
    public String getUsername() {
        return userDto.getUsername();
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
