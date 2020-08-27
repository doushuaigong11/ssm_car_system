package com.zz.service.impl;

import com.zz.dao.SysOrderMapper;
import com.zz.pojo.SysOrder;
import com.zz.service.SysOrderService;
import com.zz.vo.VOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysOrderServiceImpl implements SysOrderService {

    @Autowired
    private SysOrderMapper orderMapper;

    @Override
    public List<VOrder> findAllOrder(Integer uid) {
        return orderMapper.findAllOrder(uid);
    }

    @Override
    public int deleteById(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addOrder(Integer uid, Integer cid,Integer getid, Integer backid, String oprice) {
        String status = "已归还";

        double oprice1 = Double.parseDouble(oprice);
        SysOrder order = new SysOrder();
        order.setCid(cid);
        order.setUid(uid);
        order.setGetid(getid);
        order.setBackid(backid);
        order.setOprice(oprice1);
        order.setStatus(status);

        int i = orderMapper.insertSelective(order);
        return i;
    }

    @Override
    public int deleteOrders(Integer[] ids) {
        return orderMapper.deleteOrders(ids);
    }
}
