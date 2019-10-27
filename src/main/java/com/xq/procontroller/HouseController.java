package com.xq.procontroller;

import com.github.pagehelper.PageInfo;
import com.xq.entity.ExtHouse;
import com.xq.entity.House;
import com.xq.entity.Users;
import com.xq.services.HouseService;
import com.xq.util.HouseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前端页面User控制器
 */
@Controller
@RequestMapping("/page/HouseController/")
public class HouseController {
    @Autowired
    private HouseService houseService;


    @RequestMapping("insertHouse")
    public String insertHouse(@RequestParam(value="pfile") MultipartFile file, House house, HttpSession session){
        System.out.println("文件上传");
        try {
            //获取文件的扩展名
            String extName=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            //生成文件路径
            String time=System.currentTimeMillis()+"";
            String path="D:\\picture\\";
            File files=new File(path);
            //判断是否存在文件夹
            if(!files.exists()){
                files.mkdir();
            }
            //将数据保存到项目
            file.transferTo(new File(path+time+extName));
            //将文件名称保存导实体类中
            house.setPath(time+extName);
            //因为主键不是自增长，所以要设置id
            house.setId(System.currentTimeMillis()+"");
            //通过session获取userid
            Users users=(Users) session.getAttribute("users");
            house.setUserId(users.getId());
            house.setIspass(0);
            house.setIsdel(0);
            int i=houseService.addHouse(house);
            if(i>0){
                System.out.println("发布成功");
                return "guanli";
            }else {
                System.out.println("发布失败");
                return "guanli";
            }
        } catch (IOException e) {
                     return "error";
        }
    }

    @RequestMapping("getHouse")
    public String getHouse(Model model,HttpSession session){
        List<ExtHouse> extHouseList=houseService.getHouse(((Users)session.getAttribute("users")).getId());
        model.addAttribute("extHouseList",extHouseList);
        return "guanli";
    }

    @RequestMapping("getHouseById")
    public String getHouseById(Model model,String id){
        ExtHouse extHouse=houseService.getHouseById(id);
        System.out.println(extHouse.getTypeId());
        System.out.println(extHouse.getDistrictId());
        System.out.println(extHouse.getStreetId());
        model.addAttribute("extHouse",extHouse);
        return "updateFaBu";
    }

    @RequestMapping("updateHouseById")
    public String updateHouseById(Model model,@RequestParam(value = "pfile") MultipartFile file,House house) {
        if (file != null) {
            try {
                //获取文件的扩展名
                String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                //生成文件路径
                String time = System.currentTimeMillis() + "";
                String path = "D:\\picture\\";
                File files = new File(path);
                //判断是否存在文件夹
                if (!files.exists()) {
                    files.mkdir();
                }
                //将数据保存到项目
                file.transferTo(new File(path + time + extName));
                //将文件名称保存导实体类中
                house.setPath(time + extName);
                house.setPath(time+extName);
                //删除原来的文件
                File file1 = new File(path+time + extName);
                file1.delete();
            } catch (IOException e) {
                return "error";
            }
        }
        houseService.updateHouse(house);
        return "updateFaBu";
    }

    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
       int temp=houseService.deleteHouse(id,1);
       return "{\"temp\":"+temp+"}";
    }

    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition houseCondition,Model model){
        System.out.println("12312312321312");
        PageInfo<ExtHouse> pageInfo=houseService.searchHouse(houseCondition);
        model.addAttribute("houseCondition",houseCondition);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
