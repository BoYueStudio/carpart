package com.xiupeilian.carpart.service;

import com.xiupeilian.carpart.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findMenu(Integer id);
}
