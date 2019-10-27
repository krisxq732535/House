package com.xq.controller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.ExtHouse;
import com.xq.entity.House;
import com.xq.entity.Type;
import com.xq.services.HouseService;
import com.xq.services.TypeServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "HouseController2")
@RequestMapping("/admin/HouseController/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 查询没审核的房屋信息
     * @param pageUtil
     * @return
     */
    @RequestMapping("getCheckHouse")
    @ResponseBody
    public Map<String,Object> getCheckHouse(PageUtil pageUtil){
        PageInfo<ExtHouse> pageInfo=houseService.getCheckHouse(pageUtil,0);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    /**
     * 查询审核了的房屋的信息
     * @param pageUtil
     * @return
     */
    @RequestMapping("getCheckHouse2")
    @ResponseBody
    public Map<String,Object> getCheckHouse2(PageUtil pageUtil){
        PageInfo<ExtHouse> pageInfo=houseService.getCheckHouse(pageUtil,1);
        System.out.println("========================="+pageInfo.getList());
        System.out.println("================"+pageInfo.getTotal());
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("updatePass")
    @ResponseBody
    public Map<String,Object> updatePass(String id){
        int result=houseService.updatePass(id,1);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
       return map;
    }

    @RequestMapping("updateNotPass")
    @ResponseBody
    public Map<String,Object> updateNotPass(String id){
        int result=houseService.updatePass(id,0);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }
}
