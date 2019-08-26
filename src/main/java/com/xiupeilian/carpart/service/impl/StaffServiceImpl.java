package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.SysUserMapper;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private SysUserMapper staffMapper;
    @Override
    public List<SysUser> getStaffAll() {
        return staffMapper.getStaffAll();
    }
}
