package com.zz.service.impl;

import com.zz.dao.SysCarMapper;
import com.zz.pojo.SysCar;
import com.zz.service.SysCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysCarServiceImpl implements SysCarService {

    @Autowired
    private SysCarMapper carMapper;

    @Override
    public List<SysCar> findPriceOrder() {
        return carMapper.findPriceOrder();
    }

    @Override
    public List<SysCar> findNumberOrder() {
        return carMapper.findNumberOrder();
    }

    @Override
    public SysCar findCar(Integer cid) {
        return carMapper.selectByPrimaryKey(cid);
    }
}
