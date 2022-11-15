package com.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //重写授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问，功能页面需要对应权限
        http.authorizeRequests()
                .mvcMatchers("/backend/security/index/**").permitAll()
                .mvcMatchers("/backend/login/login").permitAll()
                .mvcMatchers("/backend/security/indexTo/**").authenticated()
                .and().formLogin().loginPage("/backend/login/login")
                    .usernameParameter("user")
                    .passwordParameter("pwd")
                    .loginProcessingUrl("/doLogin")//指定登录页面
                    .successForwardUrl("/backend/security/indexTo/pc")//登录成功后会自动跳转的路径
//                    .successHandler(new MyAuthenticationSuccessHandler())//认证成功之后时的处理  前后端分离
//                    .failureHandler(new MyAuthenticationFailureHandler())//认证失败之后时的处理  前后端分离
                    .failureForwardUrl("/backend/login/login")//认证失败跳转的页面
                .and().logout()//注销功能配置
                    .logoutUrl("/logout") //指定注销的URL  默认GET方式请求
                    .invalidateHttpSession(true)//默认 会话失效
                    .clearAuthentication(true)//默认 清除认证标记
                    .logoutSuccessUrl("/backend/login/login") //注销之后跳转的页面
//                    .logoutSuccessHandler(new MyLogout())//前后分离数据
                .and().csrf().disable();//禁止csrf跨站请求保护
//                .antMatchers("/level1/**").hasRole("vip1")
//                .antMatchers("/level2/**").hasRole("vip2")
//                .antMatchers("/level3/**").hasRole("vip3");

        //无权限则跳登录
//        http.formLogin();
//        http.formLogin().loginPage("/backend/login/login").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");//指定登录页面
//        http.csrf().disable();//关闭csrf功能
        //注销
        http.logout().logoutSuccessUrl("/backend/login/login");
    }

    //重写认证
//    @Override
    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()  链接数据库
        //链接内存
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("vip1","vip2","vip3")
                .and().withUser("test").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and().withUser("huang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and().withUser("optest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3");
    }*/
}
