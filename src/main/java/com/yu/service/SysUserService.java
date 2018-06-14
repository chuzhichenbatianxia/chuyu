package com.yu.service;

import com.yu.dao.SysUserDao;
import com.yu.entity.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    public SysUser findUserByName(String userName){
        return sysUserDao.findUserByName(userName);
    }
}
