package com.xiupeilian.carpart.controller;

import com.xiupeilian.carpart.constant.SysConstant;
import com.xiupeilian.carpart.model.*;
import com.xiupeilian.carpart.service.BrandService;
import com.xiupeilian.carpart.service.CityService;
import com.xiupeilian.carpart.service.UserService;
import com.xiupeilian.carpart.task.MailTask;
import com.xiupeilian.carpart.util.SHA1Util;
import com.xiupeilian.carpart.vo.LoginVo;
import com.xiupeilian.carpart.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private CityService cityService;
    @Autowired
    private BrandService brandService;

    /**
     * 前往登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "login/login";
    }

    @RequestMapping("login")
    public void Login(LoginVo vo, HttpServletRequest request, HttpServletResponse response) throws  Exception{
        String code=(String)request.getSession().getAttribute(SysConstant.VALIDATE_CODE);
        if(code.toUpperCase().equals(vo.getValidate().toUpperCase())){//验证 验证码
            vo.setPassword(SHA1Util.encode(vo.getPassword()));//SHA1加密，保证数据库里的信息不是明文
            SysUser user=userService.findUserByVo(vo);
            if(user!=null){
                request.getSession().setAttribute("user",user);
                response.getWriter().write("3");
            }else{//用户或密码错误
                response.getWriter().write("2");
            }

        }else{
            //验证码错误
            response.getWriter().write("1");
        }

    }

    @RequestMapping("/noauth")
    public String noauth(){
        return "exception/noauth";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(){

        return "login/forgetPassword";
    }

    @RequestMapping("/getPassword")
    public void getPassword(HttpServletRequest request,HttpServletResponse response,LoginVo vo) throws IOException, MessagingException {

        SysUser user=userService.findUserByUsernameAndEmail(vo);
        if(user==null){
            //账号和邮箱不匹配
            response.getWriter().write("1");
        }else{
            //同步修改密码流程
            //1.设置新密码
            String password=new Random().nextInt(899999)+1000000+"";


            //2.修改数据库
            user.setPassword(SHA1Util.encode(password));
            userService.updateUser(user);

            //3.发送邮箱
//            SimpleMailMessage message=new SimpleMailMessage();
//            message.setFrom("lover326@sina.cn");
//            message.setTo(user.getEmail());
//            message.setSubject("博悦网络工作室登录密码修改");
//            message.setText("您的新密码为："+password);
//            //mailSender.setDefaultEncoding("utf-8");
//            mailSender.send(message);
//
//            MailTask mailTask=new MailTask(mailSender,message);
//
//            executor.execute(mailTask);



            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("lover326@sina.cn");
            helper.setTo(user.getEmail());
            helper.setSubject("博悦网络工作室登录密码修改");
            helper.setText("您的新密码为："+password);
            mailSender.send(message);



            response.getWriter().write("2");
        }

    }

    @RequestMapping("toRegister")
    public String toRegister(HttpServletRequest request){
        //初始化数据  汽车品牌、配件种类、精品种类
        List<Brand> brandList=brandService.findBrandAll();
        List<Parts> partsList=brandService.findPartsAll();
        List<Prime> primeList=brandService.findPrimeAll();
        request.setAttribute("brandList",brandList);
        request.setAttribute("partsList",partsList);
        request.setAttribute("primeList",primeList);

        return "login/register";
    }

    @RequestMapping("/checkLoginName")
    public void checkLoginName(String loginName,HttpServletResponse response) throws IOException {
        //根据账号去数据库查询，看此账号是否存在
        SysUser user=userService.findUserByLoginName(loginName);
        if(null==user){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("2");
        }
    }

    @RequestMapping("/checkPhone")
    public void checkPhone(String telnum,HttpServletResponse response) throws IOException {
        //根据手机号去数据库查询
        SysUser user=userService.findUserByPhone(telnum);
        if(null==user){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("2");
        }
    }


    @RequestMapping("/checkEmail")
    public void checkEmail(String email,HttpServletResponse response) throws IOException {
        //根据手机号去数据库查询
        SysUser user=userService.findUserByEmail(email);
        if(null==user){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("2");
        }
    }

    @RequestMapping("/checkCompanyname")
    public void checkCompanyname(String companyname,HttpServletResponse response) throws IOException {
        //校验企业名称是否注册过
        Company company=userService.findCompanyByName(companyname);
        if(null==company){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("2");
        }
    }

    /**
     * @Description: 省市县三级联动，根据父id查询所有的子节点
     * @Author:      Administrator
     * @Param:
     * @Return
     **/
    @RequestMapping("/getCity")
    public @ResponseBody
    List<City> getCity(Integer parentId){
        parentId=parentId==null?SysConstant.CITY_CHINA_ID:parentId;
        List<City> cityList=cityService.findCitiesByParentId(parentId);
        return cityList;
    }

    @RequestMapping("/register")
    public String register(RegisterVo vo){
        //参数
        //先插入企业表，再插入用户表,需要在一个事务进行控制
        userService.addRegsiter(vo);
        return "redirect:toLogin";
    }

    @RequestMapping("toPhoneLogin")
    public String toPhoneLogin(){
        return "login/phoneLogin";
    }

}
