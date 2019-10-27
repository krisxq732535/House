package com.xq.mapper;

import com.xq.entity.District;
import com.xq.entity.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    //逆向工程中生成的这个方法时根据id进行查询返回的是id和name
    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //根据districtId删除街道表中的信息
    Integer deleteByDistrictId(Integer id);

    /**
     * 删除多个区域信息
     * @param list 区域id的集合
     * @return 返回影响行数
     */
    Integer deleteMoreDistrictId(List list);
}