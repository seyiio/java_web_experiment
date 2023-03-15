package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.rmi.ServerException;

@WebServlet(name = "outputWordServlet", value = "/outputWordServlet")
public class OutputWordServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ServletContext context=getServletContext();
response.setContentType( "application/msword" );
response.setHeader( "Content-disposition", "attachment; filename=test.doc" );
    String fileName=context.getRealPath( "/WEB-INF/test.doc" );
    File file = new File(fileName);
    BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
    BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
    byte[ ] buffer=new byte[1024];
while (bis.read(buffer)!=-1) {
    bos.write(buffer);
    bos.close();
    bis.close();
}
}
}