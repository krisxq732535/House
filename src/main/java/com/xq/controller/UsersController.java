package com.xq.controller;


import com.github.pagehelper.PageInfo;
import com.xq.entity.Users;
import com.xq.services.UsersServices;
import com.xq.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RestController=@Controller+@responsebody;该注解表示
@RequestMapping("/admin/users")
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    @RequestMapping("/searchUserLike")
    @ResponseBody
    public Map<String,Object> searchUserLike(UsersCondition usersCondition){
        PageInfo<Users> usersPageInfo = usersServices.selectTypeByPage(usersCondition);
        Map<String,Object> map = new HashMap<>();
        map.put("total",usersPageInfo.getTotal());
        map.put("rows",usersPageInfo.getList());
        System.out.println(usersPageInfo.getTotal());
        System.out.println(usersPageInfo.getList());
        return map;
    }
}
