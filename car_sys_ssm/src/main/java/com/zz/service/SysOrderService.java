package com.zz.service;

import com.zz.pojo.SysOrder;
import com.zz.vo.VOrder;

import java.util.List;

public interface SysOrderService {
    List<VOrder> findAllOrder(Integer uid);

    int deleteById(Integer id);

    int  addOrder(Integer uid, Integer cid,Integer getid, Integer backid, String oprice);

    int deleteOrders(Integer[] ids);
}
