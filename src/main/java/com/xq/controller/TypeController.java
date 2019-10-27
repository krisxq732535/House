package com.xq.controller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.Type;
import com.xq.mapper.TypeMapper;
import com.xq.services.DistrictServices;
import com.xq.services.TypeServices;
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
@RequestMapping("/admin/type")
public class TypeController {
    @Autowired
    private TypeServices typeServices;

    @RequestMapping("/selectType")
    @ResponseBody
    public List<Type> selectType(){
        List<Type> typeList=typeServices.sellectType();
        return typeList;
    }

    @RequestMapping("/selectTypeByPage")
    @ResponseBody
    public Map<String,Object> selectTypeByPage(PageUtil pageUtil){
        PageInfo<Type> pageInfo= typeServices.selectTypeByPage(pageUtil);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println(map);
        return map;
    }

    /**
     * 插入区域信息
     * */
    @RequestMapping("/insertType")
    @ResponseBody
    public Map<String,Object> insertDistrict(Type type){
        Integer result=typeServices.addType(type);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新前根据id查询区域名称
     * */
    @RequestMapping("/upselectType")
    @ResponseBody
    public Map<String,Object> upselectType(Integer id){
        Type type=typeServices.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("name",type.getName());
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 更新数据
     * @param type
     * @return
     */
    @RequestMapping("/updateType")
    @ResponseBody
    public Map<String,Object> updateType(Type type){
        Integer temp=typeServices.updateByPrimaryKey(type);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        //这里也可以返回一个json格式的字符串
        //return "{\"i\":"+i+"}";
        return map;
    }

    /**
     * 删除区域信息并删除街道信息，涉及事务处理
     */
    @RequestMapping("/deleteType")
    @ResponseBody
    public Map<String,Object> deleteType(Integer id){
        Integer temp=typeServices.deleteByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }


    @RequestMapping("/deleteMoreType")
    @ResponseBody
    public Map<String,Object> deleteMoreType(String id){
        String []strids= id.split(",");
        Integer []intids=new Integer[strids.length];
        for (int i = 0; i <intids.length; i++) {
            intids[i]=Integer.parseInt(strids[i]);
        }
        System.out.println(Arrays.asList(intids));
        Integer temp=typeServices.deleteMoreTypeId(Arrays.asList(intids));
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }
}
