package com.xq.services;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.Street;
import com.xq.util.PageUtil;

import java.util.List;

public interface StreetServices {

    /*查询所有的街道信息*/
    List<Street> sellectStreet();

    //分页查询街道
    PageInfo<Street> selectStreetByPage(PageUtil pageUtil);

    /**
     * 插入街道信息
     * */
    int addStreet(Street street);


    /**
     * 更新前根据id查询街道名称
     */
    Street selectByPrimaryKey(Integer id);

    /**
     * 实现数据的修改
     * @param street 传递实体类参数
     * @return 返回受影响的行数
     */
    Integer updateByPrimaryKey(Street street);

    /**
     * 根据id对街道进行删除
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 进行批量删除
     * @param list 查询条件
     * @return 返回查询的数据集合
     */
    Integer deleteMoreStreet(List list);

    /**
     * 查询所有的区域
     * @return
     */
    List<Street> getStreet(Integer id);

}
