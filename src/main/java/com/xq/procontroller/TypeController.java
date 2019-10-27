package com.xq.procontroller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.Type;
import com.xq.entity.Users;
import com.xq.services.TypeServices;
import com.xq.services.UsersServices;
import com.xq.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前端页面User控制器
 */
@Controller(value = "typeController2")
@RequestMapping("/page/proTypeController/")
public class TypeController {
    @Autowired
    private TypeServices typeServices;

    @RequestMapping("getType")
    @ResponseBody
    public List<Type> getType(){
        System.out.println("111");
        List<Type> typeList=typeServices.searchType();
        System.out.println(typeList);
        return typeList;
    }
}
