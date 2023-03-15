package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

response.setContentType("text/html; charset=utf-8");//获得向客户端输出的输出流
    PrintWriter out=response.getWriter();//判断用户是否登录，若没登录，则转到登录页面
    HttpSession session=request.getSession();if (session.getAttribute(  "username")==null){
        out.println("您还未登录，请先登录,3秒后跳转到登录页面!!! ");response.setHeader(  "Refresh" , "3; url=login.html");}else{
        out.println(session.getAttribute( "username")+",欢迎您使用本系统");
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
