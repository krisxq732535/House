package com.xq.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.entity.Type;
import com.xq.entity.TypeExample;
import com.xq.entity.Users;
import com.xq.entity.UsersExample;
import com.xq.mapper.TypeMapper;
import com.xq.mapper.UsersMapper;
import com.xq.services.TypeServices;
import com.xq.services.UsersServices;
import com.xq.util.MD5Utils;
import com.xq.util.PageUtil;
import com.xq.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    private UsersMapper usersMapper;
    /**
     * 实现模糊查询+分页查询
     * @param usersCondition 封装easyui传递过来的rows，page，以及查询条件：用户名+电话号码
     * @return
     */
    @Override
    public PageInfo<Users> selectTypeByPage(UsersCondition usersCondition) {
        //开启分页
        PageHelper.startPage(usersCondition.getPage(),usersCondition.getRows());
        //获取查询输入参数的操作对象
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        if(usersCondition.getName()!=null){
            criteria.andNameLike("%"+usersCondition.getName()+"%");
        }
        if(usersCondition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+usersCondition.getTelephone()+"%");
        }
        List<Users> usersList=usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo = new PageInfo<>(usersList);
        return pageInfo;
    }

    @Override
    public Integer addUser(Users users) {
        //需要对用户密码进行加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        //注册时都默认不是管理员
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users checkName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Users> usersList=usersMapper.selectByExample(usersExample);
        if(usersList.size()>0){
            return usersList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Users login(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users =usersMapper.selectByExample(usersExample);
        System.out.println(users);
        if(users.size()==0){
            return null;
        }else {
            return users.get(0);
        }
    }
}
