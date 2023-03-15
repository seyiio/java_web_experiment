package com.example.demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessservlet" , value= "/LastAccessservlet")public class LastAccessServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType( "text/html; charset=utf-8");
        Cookie[] cookies=request.getCookies();
//定义flag的boolean变量，用于判断cookies是否为空
boolean flag=false;
        //遍历cookie数组
 if(cookies!=null){
            for(Cookie cookie :cookies) {
//获取cookie的名称
                String name=cookie. getName();//判断名称是否是lastTime
                if("lastTime".equals(name)){
//有该cookie不是第一次访问

flag=true;
//响应数据
//获取cookie 的value时间
                    String value=cookie.getValue();//URL解码
                    value= URLDecoder.decode(value, "utf-8");
                    response.getWriter().write(  "欢迎回来，您上次访问时间为: "+value);break;
                }
            }
//如果没找到cookie，说明是第一次访问
if(!flag){
            response.getWriter( ).write( "您好，欢迎您首次访问");}
//将本次访问时间写回客户端
//获取当前时间的字符串，重新设置cookie的值，重新发送
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss");
        String str_date=sdf.format(date);
//URL编码
        str_date= URLEncoder.encode(str_date, "utf-8");//创建cookie对象
        Cookie cookie=new Cookie(  "lastTime" , str_date);//设置cookie存活时间
        cookie.setMaxAge(60*60*24*30);//一个月
         response.addCookie(cookie);}}
        public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
            this.doGet(request, response);
        }
}
