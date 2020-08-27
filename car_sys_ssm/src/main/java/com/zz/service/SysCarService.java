package com.zz.service;

import com.zz.pojo.SysCar;

import java.util.List;

public interface SysCarService {
    List<SysCar> findPriceOrder();

    List<SysCar> findNumberOrder();

    SysCar findCar(Integer cid);
}
