package com.xiupeilian.carpart.servlet;

import com.xiupeilian.carpart.util.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login/Kaptcha.jpg")
public class Kaptcha extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/jpeg");  
	          
	        //生成随机字串  
	        String verifyCode = ImageUtil.generateVerifyCode(4);  
	        //将生成的图形验证码当中的字符串存session,将来使用spring-session-redis
	        request.getSession().setAttribute("validate", verifyCode);
	        
	       
	        //生成图片  
	        int w = 200, h = 80;  
	        ImageUtil.outputImage(w, h, response.getOutputStream(), verifyCode);  
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
	
	

}
