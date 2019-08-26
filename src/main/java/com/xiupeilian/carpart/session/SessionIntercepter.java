package com.xiupeilian.carpart.session;

import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.MenuService;
import com.xiupeilian.carpart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SessionIntercepter implements HandlerInterceptor {

    @Autowired
    private MenuService menuService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //session拦截以及权限控制
        String path=request.getRequestURI();
        if(path.contains("login")){
            //判断是否是登录页面，登录页面不需要拦截
            return true;
        }else{
            //接着判断sesseion是否为空
            HttpSession session=request.getSession(false);
            if(session==null){
                response.sendRedirect(request.getContextPath()+"/login/toLogin");
                return false;
            }else{
                //判断session里面是否有key为user的session
                if(session.getAttribute("user")==null){
                    response.sendRedirect(request.getContextPath()+"/login/toLogin");
                    return false;
                }else{
                    //用户已经登录了，现在进行权限控制
                    SysUser user=(SysUser)session.getAttribute("user");
                    //查找用户的权限menulist
                    List<Menu> menuList=menuService.findMenu(user.getId());
                    boolean check=false;
                    for(Menu m:menuList){
                        if(path.contains(m.getMenuKey())){
                            check=true;
                        }
                    }

                    if(check){
                        return true;
                    }else{
                        //转发的非法访问页面
                        response.sendRedirect(request.getContextPath()+"/login/noauth");
                        return false;
                    }
                }
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            request.setAttribute("ctx",request.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
