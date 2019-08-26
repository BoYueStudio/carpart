package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.vo.LoginVo;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findUserByVo(LoginVo vo);

    SysUser findUserByUsernameAndEmail(LoginVo vo);

    List<SysUser> getStaffAll();

    SysUser findUserByLoginName(String loginName);

    SysUser findUserByPhone(String telnum);

    SysUser findUserByEmail(String email);
}