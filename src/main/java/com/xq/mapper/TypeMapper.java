package com.xq.mapper;

import com.xq.entity.Type;
import com.xq.entity.TypeExample;
import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    /**
     * 删除多个房屋类型信息
     * @param list 类型id的集合
     * @return 返回影响行数
     */
    Integer deleteMoreTypeId(List list);
}