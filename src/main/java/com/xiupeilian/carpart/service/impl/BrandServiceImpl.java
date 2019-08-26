package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.BrandMapper;
import com.xiupeilian.carpart.mapper.PartsMapper;
import com.xiupeilian.carpart.mapper.PrimeMapper;
import com.xiupeilian.carpart.model.Brand;
import com.xiupeilian.carpart.model.Parts;
import com.xiupeilian.carpart.model.Prime;
import com.xiupeilian.carpart.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private PartsMapper partsMapper;
    @Autowired
    private PrimeMapper primeMapper;
    @Override
    public List<Brand> findBrandAll() {
        return brandMapper.findBrandAll();
    }

    @Override
    public List<Parts> findPartsAll() {
        return partsMapper.findPartsAll();
    }

    @Override
    public List<Prime> findPrimeAll() {
        return primeMapper.findPrimeAll();
    }
}
