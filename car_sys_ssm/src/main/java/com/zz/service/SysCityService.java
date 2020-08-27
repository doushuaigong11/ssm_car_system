package com.zz.service;

import com.zz.pojo.SysCity;
import com.zz.vo.VCity;

import java.util.List;

public interface SysCityService {
    List<SysCity> findAllCity(Integer pid);

    VCity findCity(Integer getid, Integer backid);
}
