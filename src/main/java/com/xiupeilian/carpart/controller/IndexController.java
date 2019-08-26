package com.xiupeilian.carpart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiupeilian.carpart.model.Dymsn;
import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.model.Notice;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.DymsnService;
import com.xiupeilian.carpart.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DymsnService dymsnService;

    /**
     * 登录后前往index
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex(){

        return "index/index";
    }

    /**
     * 首页top
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("top")
    public String top(HttpServletRequest request,HttpServletResponse response){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());

        request.setAttribute("now",now);
        return "index/top";
    }

    /**
     * 导航信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("navigation")
    public String navigation(HttpServletRequest request,HttpServletResponse response){
        SysUser user=(SysUser)request.getSession().getAttribute("user");
        Integer id=user.getId();
        List<Menu> menuList=menuService.findMenu(id);
        request.setAttribute("menuList",menuList);

        return "index/navigation";
    }

    /**
     * 动态消息list
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("dymsn")
    public String dymsn(HttpServletResponse response,HttpServletRequest request){
        List<Dymsn> list= dymsnService.findDymsn();
        request.setAttribute("list",list);
        return "index/dymsn";
    }

    @RequestMapping("notice")
    public String notice(Integer pageSize,Integer pageNum, HttpServletRequest request){
        pageSize=pageSize==null?10:pageSize;
        pageNum=pageNum==null?1:pageNum;
        PageHelper.startPage(pageNum,pageSize);

        List<Notice> list=dymsnService.findNotice();
        PageInfo<Notice> page=new PageInfo<>(list);
        request.setAttribute("page",page);
        return "index/notice";
    }


}
