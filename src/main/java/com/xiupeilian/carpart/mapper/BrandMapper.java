package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Brand;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> findBrandAll();
}