package com.xq.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.entity.District;
import com.xq.entity.DistrictExample;
import com.xq.mapper.DistrictMapper;
import com.xq.services.DistrictServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServicesImpl implements DistrictServices {

    @Autowired
    private DistrictMapper districtMapper;
    /*查询所有的区域信息*/
    @Override
    public List<District> sellectDistrict() {
        //selectByExample是查询的条件进行封装
        return districtMapper.selectByExample(new DistrictExample());
    }

    /*分页查询区域信息*/
    @Override
    public PageInfo<District> selectDistrictByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        DistrictExample districtExample = new DistrictExample();
        PageInfo<District> pageInfo=new PageInfo(districtMapper.selectByExample(districtExample));
        return pageInfo;
    }

    /**
     * 插入区域信息
     * */
    @Override
    public int addDistrict(District district) {
        return  districtMapper.insertSelective(district);
    }

    @Override
    public District selectByPrimaryKey(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }


    @Override
    public Integer updateByPrimaryKey(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    /**
     * 根据区域id删除街道信息，涉及事务处理
     * @param id
     * @return
     */
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        //涉及事务，删除区域表中的某条信息前先删除属于街道表的对应的那条信息
        //1.先删除街道表的信息
        districtMapper.deleteByDistrictId(id);
        //2.再删除区域表的信息
        districtMapper.deleteByPrimaryKey(id);
        return 1;
    }

    /**
     *
     * @param list 查询条件
     * @return 返回查询的结果
     */
    @Override
    public Integer deleteMoreDistrict(List list) {
        return districtMapper.deleteMoreDistrictId(list);
    }

    @Override
    public List<District> getDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
