package com.security.config;

import com.security.dao.UserDao;
import com.security.entity.Role;
import com.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class UserServiceConfig implements UserDetailsService {


    @Autowired
    private UserDao userDao;

    


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //获取用户
        User user = userDao.loadUserByUsername(userName);
        if(ObjectUtils.isEmpty(user)) throw new UsernameNotFoundException("用户名不正确！");

        //返回权限信息
        List<Role> roles = userDao.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;

    }
}
