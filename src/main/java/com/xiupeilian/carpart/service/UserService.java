package com.xiupeilian.carpart.service;

import com.xiupeilian.carpart.model.Company;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.vo.LoginVo;
import com.xiupeilian.carpart.vo.RegisterVo;

public interface UserService {

    SysUser findUserByVo(LoginVo vo);

    SysUser findUserByUsernameAndEmail(LoginVo vo);

    void updateUser(SysUser user);

    SysUser findUserByLoginName(String loginName);

    SysUser findUserByPhone(String telnum);

    SysUser findUserByEmail(String email);

    Company findCompanyByName(String companyname);

    void addRegsiter(RegisterVo vo);
}
