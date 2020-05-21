package cn.sucre.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码防止中文乱码
        response.setContentType("text/html;charset=utf-8");
//        输出字符数据
        PrintWriter pw = response.getWriter();
        pw.write("你好,response!");

//        输出字节数据
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write("hello".getBytes());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
