package com.xq.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.DistrictExample;
import com.xq.entity.Street;
import com.xq.entity.StreetExample;
import com.xq.mapper.DistrictMapper;
import com.xq.mapper.StreetMapper;
import com.xq.services.DistrictServices;
import com.xq.services.StreetServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServicesImpl implements StreetServices {

    @Autowired
    private StreetMapper streetMapper;
    /*查询所有的区域信息*/
    @Override
    public List<Street> sellectStreet() {
        //selectByExample是查询的条件进行封装
        return streetMapper.selectByExample(new StreetExample());
    }

    /*分页查询区域信息*/
    @Override
    public PageInfo<Street> selectStreetByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        StreetExample streetExample = new StreetExample();
        PageInfo<Street> pageInfo=new PageInfo(streetMapper.selectByExample(streetExample));
        return pageInfo;
    }

    /**
     * 插入区域信息
     * */
    @Override
    public int addStreet(Street street) {
        return  streetMapper.insertSelective(street);
    }

    @Override
    public Street selectByPrimaryKey(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }


    @Override
    public Integer updateByPrimaryKey(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    /**
     * 根据区域id删除街道信息，涉及事务处理
     * @param id
     * @return
     */
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    /**
     *
     * @param list 查询条件
     * @return 返回查询的结果
     */
    @Override
    public Integer deleteMoreStreet(List list) {
        return streetMapper.deleteMoreStreetId(list);
    }


    @Override
    public List<Street> getStreet(Integer id) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return streetMapper.selectByExample(streetExample);
    }
}
