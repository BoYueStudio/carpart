package com.xiupeilian.carpart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiupeilian.carpart.model.Notice;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @RequestMapping("/staffList")
    public String staffList(Integer pageSize,Integer pageNum, HttpServletRequest request) throws IOException {
        pageSize=pageSize==null?10:pageSize;
        pageNum=pageNum==null?1:pageNum;
        PageHelper.startPage(pageNum,pageSize);

        List<SysUser> list= staffService.getStaffAll();

        PageInfo<SysUser> page=new PageInfo<>(list);
        request.setAttribute("page",page);
        return "staff/staffList";
    }
}
