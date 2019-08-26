package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Company;

public interface CompanyMapper extends BaseMapper<Company> {

    Company findCompanyByName(String companyname);
}