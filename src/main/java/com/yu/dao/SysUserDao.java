package com.yu.dao;

import com.yu.entity.SysUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SysUserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public SysUser findUserByName(String userName){
        List<SysUser> sysUser=jdbcTemplate.query("SELECT *FROM sys_user WHERE userName=?",new String[]{userName},new BeanPropertyRowMapper<SysUser>(SysUser.class));
        return sysUser.get(0);
    }
}
