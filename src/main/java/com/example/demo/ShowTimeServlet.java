package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowTimeServlet",value = "/ShowTimeServlet")
public class ShowTimeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        ServletContext context = getServletContext();
        Integer times = (Integer) context.getAttribute(  "times");
        if (times == null) {
            times = 1;}else {
            times = times+1;
        }
        out.println("<html><head><title>");out.println("页面访问统计");
        out.println("</title></head><body>");out.println("当前页面被访问了");
        out.println("<font color=red size=20>"+times+"</font>次");
        context.setAttribute(  "times" ,times);

    }
}
