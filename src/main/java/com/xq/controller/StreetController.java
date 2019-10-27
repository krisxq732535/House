package com.xq.controller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.Street;
import com.xq.services.DistrictServices;
import com.xq.services.StreetServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController=@Controller+@responsebody;该注解表示
@RequestMapping("/admin/street")
public class StreetController {
    @Autowired
    private StreetServices streetServices;

    @RequestMapping("/selectStreet")
    @ResponseBody
    public List<Street> selectStreet(){
        List<Street> streetList=streetServices.sellectStreet();
        return streetList;
    }

    @RequestMapping("/selectStreetByPage")
    @ResponseBody
    public Map<String,Object> selectStreetByPage(PageUtil pageUtil){
        PageInfo<Street> pageInfo=streetServices.selectStreetByPage(pageUtil);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        //System.out.println(map);
        //System.out.println(pageInfo.getList());
        return map;
    }

    /**
     * 插入街道信息
     * */
    @RequestMapping("/insertStreet")
    @ResponseBody
    public Map<String,Object> insertStreet(Street street){
        Integer result=streetServices.addStreet(street);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新前根据id查询街道名称
     * */
    @RequestMapping("/upselectStreet")
    @ResponseBody
    public Map<String,Object> upselectStreet(Integer id){
        Street street=streetServices.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("name",street.getName());
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新数据
     * @param street
     * @return
     */
    @RequestMapping("/updateStreet")
    @ResponseBody
    public Map<String,Object> updateDistrict(Street street){
        Integer temp=streetServices.updateByPrimaryKey(street);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    @RequestMapping("/deleteStreet")
    @ResponseBody
    public Map<String,Object> deleteStreet(Integer id){
        Integer temp=streetServices.deleteByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }


    @RequestMapping("/deleteMoreStreet")
    @ResponseBody
    public Map<String,Object> deleteMoreStreet(String id){
        String []strids= id.split(",");
        Integer []intids=new Integer[strids.length];
        for (int i = 0; i <intids.length; i++) {
            intids[i]=Integer.parseInt(strids[i]);
        }
        System.out.println(Arrays.asList(intids));
        Integer temp=streetServices.deleteMoreStreet(Arrays.asList(intids));
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }
}
