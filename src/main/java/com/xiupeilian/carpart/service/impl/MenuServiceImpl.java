package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.MenuMapper;
import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findMenu(Integer id) {
        return menuMapper.findMenu(id);
    }
}
