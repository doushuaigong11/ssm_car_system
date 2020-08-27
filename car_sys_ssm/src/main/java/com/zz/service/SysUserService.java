package com.zz.service;

import com.zz.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser login(SysUser sysUser);

    int register(SysUser sysUser);

    List<SysUser> findOne(Integer id);

    int updatePassword(SysUser sysUser);

}
