package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> findCitiesByParentId(Integer parentId);
}