package com.zz.dao;

import com.zz.pojo.SysCar;
import com.zz.pojo.SysCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCarMapper {
    long countByExample(SysCarExample example);

    int deleteByExample(SysCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCar record);

    int insertSelective(SysCar record);

    List<SysCar> selectByExample(SysCarExample example);

    SysCar selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") SysCar record, @Param("example") SysCarExample example);

    int updateByExample(@Param("record") SysCar record, @Param("example") SysCarExample example);

    int updateByPrimaryKeySelective(SysCar record);

    int updateByPrimaryKey(SysCar record);

    List<SysCar> findPriceOrder();

    List<SysCar> findNumberOrder();
}