package com.xq.procontroller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.Street;
import com.xq.entity.Type;
import com.xq.entity.Users;
import com.xq.services.StreetServices;
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
@Controller(value = "streetController2")
@RequestMapping("/page/proStreetController/")
public class StreetController {

    @Autowired
    private StreetServices streetServices;

    @RequestMapping("getStreet")
    @ResponseBody
    public List<Street> getStreet(Integer id){
        return streetServices.getStreet(id);
    }
}
