package com.zz.service.impl;

import com.zz.dao.SysUserMapper;
import com.zz.pojo.SysUser;
import com.zz.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        return sysUserMapper.login(sysUser);
    }

    @Override
    public int register(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public List<SysUser> findOne(Integer id) {
        return sysUserMapper.findOne(id);
    }

    @Override
    public int updatePassword(SysUser sysUser) {
        System.err.println(sysUser + "--------------");
        return sysUserMapper.updatePassword(sysUser);
    }
}
