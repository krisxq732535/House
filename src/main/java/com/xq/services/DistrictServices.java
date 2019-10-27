package com.xq.services;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.util.PageUtil;

import java.util.List;

public interface DistrictServices {

    /*查询所有的区域信息*/
    List<District> sellectDistrict();

    //分页查询区域
    PageInfo<District> selectDistrictByPage(PageUtil pageUtil);

    /**
     * 插入区域信息
     * */
    int addDistrict(District district);


    /**
     * 更新前根据id查询区域名称
     */
    District selectByPrimaryKey(Integer id);

    /**
     * 实现数据的修改
     * @param district 传递实体类参数
     * @return 返回受影响的行数
     */
    Integer updateByPrimaryKey(District district);

    /**
     * 根据id对区域进行删除
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 进行批量删除
     * @param list 查询条件
     * @return 返回查询的数据集合
     */
    Integer deleteMoreDistrict(List list);

    List<District> getDistrict();
}
