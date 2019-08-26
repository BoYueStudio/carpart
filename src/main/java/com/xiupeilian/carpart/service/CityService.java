package com.xiupeilian.carpart.service;

import com.xiupeilian.carpart.model.City;

import java.util.List;

public interface CityService {
    List<City> findCitiesByParentId(Integer parentId);
}
