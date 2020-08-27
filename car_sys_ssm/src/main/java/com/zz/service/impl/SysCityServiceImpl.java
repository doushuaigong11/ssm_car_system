package com.zz.service.impl;

import com.zz.dao.SysCityMapper;
import com.zz.pojo.SysCity;
import com.zz.service.SysCityService;
import com.zz.vo.VCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCityServiceImpl implements SysCityService {
    @Autowired
    private SysCityMapper cityMapper;

    @Override
    public List<SysCity> findAllCity(Integer pid) {
        return cityMapper.findAllCity(pid);
    }

    @Override
    public VCity findCity(Integer getid, Integer backid) {
        SysCity getCity = cityMapper.findCity(getid);
        SysCity backcity = cityMapper.findCity(backid);
        VCity vCity = new VCity();
        vCity.setGetCity(getCity);
        vCity.setBackCity(backcity);
        return vCity;
    }


}
