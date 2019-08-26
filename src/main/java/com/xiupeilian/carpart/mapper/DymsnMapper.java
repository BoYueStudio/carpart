package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Dymsn;

import java.util.List;

public interface DymsnMapper  extends BaseMapper<Dymsn> {
    List<Dymsn> findDymsn();
}