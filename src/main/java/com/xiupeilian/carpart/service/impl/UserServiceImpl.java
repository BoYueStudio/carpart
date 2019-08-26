package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.constant.SysConstant;
import com.xiupeilian.carpart.mapper.CompanyMapper;
import com.xiupeilian.carpart.mapper.SysUserMapper;
import com.xiupeilian.carpart.model.Company;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.UserService;
import com.xiupeilian.carpart.util.SHA1Util;
import com.xiupeilian.carpart.vo.LoginVo;
import com.xiupeilian.carpart.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public SysUser findUserByVo(LoginVo vo) {
        return userMapper.findUserByVo(vo);
    }

    @Override
    public SysUser findUserByUsernameAndEmail(LoginVo vo) {
        return userMapper.findUserByUsernameAndEmail(vo);
    }

    @Override
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public SysUser findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }

    @Override
    public SysUser findUserByPhone(String telnum) {
        return userMapper.findUserByPhone(telnum);
    }

    @Override
    public SysUser findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public Company findCompanyByName(String companyname) {
        return companyMapper.findCompanyByName(companyname);
    }

    @Override
    public void addRegsiter(RegisterVo vo) {
        //先插入企业表
        Company company=new Company();
        company.setAddress(vo.getAddress());
        company.setCity(vo.getCity());
        company.setCompanyCode(UUID.randomUUID().toString());
        company.setCompanyName(vo.getCompanyname());
        company.setCounty(vo.getContry());
        company.setCreateTime(new Date());
        company.setLeader(vo.getUsername());
        company.setMain(vo.getMain());
        company.setPhone(vo.getPhone());
        company.setZone1(vo.getZone1());
        company.setZone2(vo.getZone2());
        company.setTel1(vo.getTel1());
        company.setTel2(vo.getTel2());
        company.setPrime(vo.getPrime());
        company.setSingleParts(vo.getSingleParts());
        company.setQq(vo.getQq());
        companyMapper.insertSelective(company);

        //再插入用户表
        SysUser user=new SysUser();
        user.setPassword(SHA1Util.encode(vo.getPassword()));
        user.setCompanyId(company.getId());
        user.setCreateTime(new Date());
        user.setEmail(vo.getEmail());
        user.setLoginName(vo.getLoginName());
        user.setManageLevel(1);
        user.setPhone(vo.getPhone());
        user.setRoleId(SysConstant.ROLE_ADMIN);
        user.setUsername(vo.getUsername());
        userMapper.insertSelective(user);
    }
}
