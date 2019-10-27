package com.xq.services;

import com.github.pagehelper.PageInfo;
import com.xq.entity.Type;
import com.xq.entity.Users;
import com.xq.util.PageUtil;
import com.xq.util.UsersCondition;

import java.util.List;

public interface UsersServices {

    //分页查询类型
    PageInfo<Users> selectTypeByPage(UsersCondition usersCondition);

    /**
     * 实现用户注册功能
     * @param users 用户信息
     * @return 影响的就行数
     */
    Integer addUser(Users users);

    /**
     * 检查用户名是否存在
     * @param name 用户名
     * @return 返回影响行数
     */
    Users checkName(String name);

    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    Users login(String name,String password);
}
