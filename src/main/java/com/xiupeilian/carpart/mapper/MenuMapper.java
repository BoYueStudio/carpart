package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenu(Integer id);
}