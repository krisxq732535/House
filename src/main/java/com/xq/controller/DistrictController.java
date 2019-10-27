package com.xq.controller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.services.DistrictServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController=@Controller+@responsebody;该注解表示
@RequestMapping("/admin/district")
public class DistrictController {
    @Autowired
    private DistrictServices districtServices;

    @RequestMapping("/selectDistrict")
    @ResponseBody
    public List<District> selectDistrict(){
        List<District> districtList=districtServices.sellectDistrict();
        return districtList;
    }

    @RequestMapping("/selectDistrictByPage")
    @ResponseBody
    public Map<String,Object> selectDistrictByPage(PageUtil pageUtil){
        PageInfo<District> pageInfo=districtServices.selectDistrictByPage(pageUtil);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println(pageInfo.getList());
        return map;
    }

    /**
     * 插入区域信息
     * */
    @RequestMapping("/insertDistrict")
    @ResponseBody
    public Map<String,Object> insertDistrict(District district){
        Integer result=districtServices.addDistrict(district);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新前根据id查询区域名称
     * */
    @RequestMapping("/upselectDistrict")
    @ResponseBody
    public Map<String,Object> upselectDistrict(Integer id){
        District district=districtServices.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("name",district.getName());
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新数据
     * @param district
     * @return
     */
    @RequestMapping("/updateDistrict")
    @ResponseBody
    public Map<String,Object> updateDistrict(District district){
        Integer temp=districtServices.updateByPrimaryKey(district);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 删除区域信息并删除街道信息，涉及事务处理
     */
    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public Map<String,Object> deleteDistrict(Integer id){
        Integer temp=districtServices.deleteByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }


    @RequestMapping("/deleteMoreDistrict")
    @ResponseBody
    public Map<String,Object> deleteMoreDistrict(String id){
        String []strids= id.split(",");
        Integer []intids=new Integer[strids.length];
        for (int i = 0; i <intids.length; i++) {
            intids[i]=Integer.parseInt(strids[i]);
        }
        System.out.println(Arrays.asList(intids));
        Integer temp=districtServices.deleteMoreDistrict(Arrays.asList(intids));
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }
}
