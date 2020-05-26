package cn.sucre.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取ServletContext对象
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext1==servletContext2);
        System.out.println(servletContext1);
        System.out.println(servletContext2);

//      功能1：获取MIME类型
        String filename = "a.jpg";
        String mimeType = servletContext1.getMimeType(filename);
        System.out.println(mimeType);
//      功能2：共享数据
        servletContext1.setAttribute("msg","hh");
//      功能3：获取文件真实（服务器）路径

        String b = servletContext1.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);

        String c = servletContext1.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = servletContext1.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
