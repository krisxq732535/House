package com.xq.services;

import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.Type;
import com.xq.util.PageUtil;

import java.util.List;

public interface TypeServices {

    /*查询所有的类型信息*/
    List<Type> sellectType();

    //分页查询类型
    PageInfo<Type> selectTypeByPage(PageUtil pageUtil);

    /**
     * 插入类型信息
     * */
    int addType(Type type);


    /**
     * 更新前根据id查询类型名称
     */
    Type selectByPrimaryKey(Integer id);

    /**
     * 实现数据的修改
     * @param type 传递实体类参数
     * @return 返回受影响的行数
     */
    Integer updateByPrimaryKey(Type type);

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
    Integer deleteMoreTypeId(List list);

    /**
     * 查询房屋类型
     * @return 返回所有的房屋类型
     */
    List<Type> searchType();


}
