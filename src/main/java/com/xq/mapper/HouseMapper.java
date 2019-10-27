package com.xq.mapper;

import com.xq.entity.ExtHouse;
import com.xq.entity.House;
import com.xq.entity.HouseExample;
import com.xq.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<ExtHouse> getHouse(Integer id);

    ExtHouse getHouseById(String id);

    List<ExtHouse> getCheckHouse(Integer status);

    List<ExtHouse> searchHouse(HouseCondition houseCondition);
}