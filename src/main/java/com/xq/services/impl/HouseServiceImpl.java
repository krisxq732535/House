package com.xq.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.entity.ExtHouse;
import com.xq.entity.House;
import com.xq.entity.HouseExample;
import com.xq.mapper.HouseMapper;
import com.xq.services.HouseService;
import com.xq.util.HouseCondition;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService
{

    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public List<ExtHouse> getHouse(Integer id) {
        return houseMapper.getHouse(id);
    }

    @Override
    public ExtHouse getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int updateHouse(House house) {

        int i=houseMapper.updateByPrimaryKeySelective(house);
        return i;
    }

    @Override
    public int deleteHouse(String id, Integer status) {
        House house = new House();
        house.setId(id);
        house.setIsdel(status);
        int temp=houseMapper.updateByPrimaryKeySelective(house);
        System.out.println(temp);
        return temp;
    }

    @Override
    public PageInfo<ExtHouse> getCheckHouse(PageUtil pageUtil,Integer status) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<ExtHouse> list=houseMapper.getCheckHouse(status);
        return new PageInfo<ExtHouse>(list);
    }

    @Override
    public int updatePass(String id, Integer status) {
        House house = new House();
        house.setId(id);
        house.setIspass(status);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<ExtHouse> searchHouse(HouseCondition houseCondition) {
        System.out.println("page:"+houseCondition.getPage());
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<ExtHouse> list=houseMapper.searchHouse(houseCondition);
        return new PageInfo<ExtHouse>(list);
    }
}
