package com.example.config;

import com.example.config.userservice.MyUserDetailsServiceImpl;
import com.example.config.exception.MyAccessDeniedHandler;
import com.example.config.exception.MyAuthenticationEntryPoint;
import com.example.filter.AuthorizationTokenFilter;
import com.example.jwt.JwtProvider;
import com.example.properties.JwtProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author jiangqiangqiang
 * @Description: 配置文件
 * @date 2021/10/19 7:48 下午
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private MyUserDetailsServiceImpl myUserDetailsServiceImpl;
    @Resource
    private MyAuthenticationEntryPoint authEntryPoint;
    @Resource
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Resource
    private JwtProvider jwtProvider;

    /**
     * 密码加密
     *
     * @return /
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 指定认证对象来源
     *
     * @param auth /
     * @throws Exception /
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 用户注册的时候密码加密
        auth.userDetailsService(myUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests()开启权限认证
        // anyRequest().authenticated()所有的请求都要认证才能访问
        // formLogin()对应表单认证
        // logout()对应注销配置
        http.csrf().disable()
                // 认证失败处理
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(myAccessDeniedHandler).and()
                // 基于token，不要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 防止iframe 造成跨域
                .headers().frameOptions().disable().and().formLogin().and()
                // 过滤请求
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/index").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**"
                ).permitAll()
                // 放行OPTIONS请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 需要鉴权认证的
                .anyRequest().authenticated()
                // 添加过滤器
                .and().addFilter(new AuthorizationTokenFilter(authenticationManagerBean(),jwtProvider,myUserDetailsServiceImpl));
    }

    /**
     * AuthenticationManager加入spring容器
     *
     * @return /
     * @throws Exception /
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
