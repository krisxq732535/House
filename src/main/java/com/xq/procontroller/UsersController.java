package com.xq.procontroller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.Users;
import com.xq.services.UsersServices;
import com.xq.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端页面User控制器
 */
@Controller(value = "usersController2")
@RequestMapping("/page/proUserController/")
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    /**
     * 添加用户信息
     * @param users 用户信息
     * @return 页面
     */
    @RequestMapping("reg")
    public String reg(Users users){
       Integer temp=usersServices.addUser(users);
       if(temp>0){
           return "login";
       } else{
           return "regs";
       }
    }

    @RequestMapping("check")
    @ResponseBody
    public Map<String,Object> check(String name, HttpSession session){
        Users users=usersServices.checkName(name);
        Map<String,Object> map = new HashMap<>();
        if(users.getName()!=null){
            map.put("result",1);
        }else {
            map.put("result",0);
        }
        return map;
    }

    @RequestMapping("login")
    public String login(String name, String password,HttpSession session){
        Users users=usersServices.login(name,password);
        session.setAttribute("users",users);
        return "forward:/page/HouseController/getHouse.do";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
}
