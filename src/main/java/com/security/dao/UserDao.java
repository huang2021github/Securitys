package com.security.dao;

import com.security.entity.Role;
import com.security.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User loadUserByUsername(String userName);

    //查询权限
    List<Role> getRolesByUid(Integer uid);
}
