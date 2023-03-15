package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
//验证用户名密码是否正确，假定正确用户名为admin，密码为123
        if ("admin".equals(name) && "123".equals(pwd)) {
//获得session对象
            HttpSession session = request.getSession();//在Session对象中保存记住登录的用户名
            session.setAttribute("username", name);//跳转到MainServlet
            response.sendRedirect("MainServlet");
        } else {
            out.println("用户名/密码错误,3秒后返回登录页面! !! ");
            response.setHeader("Refresh", "3;url=login.html");

        }
    }
}