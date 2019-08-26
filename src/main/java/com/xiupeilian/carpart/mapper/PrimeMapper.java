package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Prime;

import java.util.List;

public interface PrimeMapper  extends BaseMapper<Prime> {

    List<Prime> findPrimeAll();
}