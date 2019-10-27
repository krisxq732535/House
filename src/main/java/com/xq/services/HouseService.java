package com.xq.services;

import com.github.pagehelper.PageInfo;
import com.xq.entity.ExtHouse;
import com.xq.entity.House;
import com.xq.util.HouseCondition;
import com.xq.util.PageUtil;

import java.util.List;

public interface HouseService {

    int addHouse(House house);

    /**
     * 获取界面信息
     * @param id userid
     * @return 连接查询到的信息
     */
    List<ExtHouse> getHouse(Integer id);

    ExtHouse getHouseById(String id);

    int updateHouse(House house);

    /**
     * 逻辑删除house
     * @param id 房屋编号
     * @param status 房屋状态（方便以后恢复）
     * @return
     */
    int deleteHouse(String id,Integer status);

    /**
     * 返回的是未审核的数据
     * @param pageUtil
     * @param status
     * @return
     */
    PageInfo<ExtHouse> getCheckHouse(PageUtil pageUtil,Integer status);

    /**
     * 返回影响行数
     * @param id 房屋编号
     * @param status 是否通过的状态
     * @return
     */
    int updatePass(String id,Integer status);

    /**
     * 实现list界面的查询信息
     * @param houseCondition
     * @return
     */
    PageInfo<ExtHouse> searchHouse(HouseCondition houseCondition);
}
