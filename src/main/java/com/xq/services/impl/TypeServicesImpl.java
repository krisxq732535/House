package com.xq.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.entity.Street;
import com.xq.entity.StreetExample;
import com.xq.entity.Type;
import com.xq.entity.TypeExample;
import com.xq.mapper.StreetMapper;
import com.xq.mapper.TypeMapper;
import com.xq.services.StreetServices;
import com.xq.services.TypeServices;
import com.xq.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServicesImpl implements TypeServices {

    @Autowired
    private TypeMapper typeMapper;
    /*查询所有的类型信息*/
    @Override
    public List<Type> sellectType() {
        //selectByExample是查询的条件进行封装
        return typeMapper.selectByExample(new TypeExample());
    }

    /*分页查询类型信息*/
    @Override
    public PageInfo<Type> selectTypeByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        TypeExample typeExample = new TypeExample();
        PageInfo<Type> pageInfo=new PageInfo(typeMapper.selectByExample(typeExample));
        return pageInfo;
    }

    /**
     * 插入类型信息
     * */
    @Override
    public int addType(Type type) {
        return  typeMapper.insertSelective(type);
    }

    @Override
    public Type selectByPrimaryKey(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }


    @Override
    public Integer updateByPrimaryKey(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    /**
     * 根据区域id删除街道信息，涉及事务处理
     * @param id
     * @return
     */
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    /**
     *
     * @param list 查询条件
     * @return 返回查询的结果
     */
    @Override
    public Integer deleteMoreTypeId(List list) {
        return typeMapper.deleteMoreTypeId(list);
    }


    @Override
    public List<Type> searchType() {
        TypeExample typeExample = new TypeExample();
        return typeMapper.selectByExample(typeExample);
    }

}
