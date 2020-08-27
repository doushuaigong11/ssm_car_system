package com.zz.dao;

import com.zz.pojo.SysOrder;
import com.zz.pojo.SysOrderExample;
import java.util.List;

import com.zz.vo.VOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOrderMapper {
    long countByExample(SysOrderExample example);

    int deleteByExample(SysOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysOrder record);

    int insertSelective(SysOrder record);

    List<SysOrder> selectByExample(SysOrderExample example);

    SysOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysOrder record, @Param("example") SysOrderExample example);

    int updateByExample(@Param("record") SysOrder record, @Param("example") SysOrderExample example);

    int updateByPrimaryKeySelective(SysOrder record);

    int updateByPrimaryKey(SysOrder record);

    List<VOrder> findAllOrder(Integer uid);

   int deleteOrders(Integer[] ids);
}