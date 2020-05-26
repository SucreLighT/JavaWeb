package cn.sucre.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/DownloadPictureServlet")
public class DownloadPictureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      1.获取请求参数
        String filename = request.getParameter("filename");
//      2.使用字节输入流加载文件
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(filename);
        System.out.println(realPath);
        FileInputStream fileInputStream = new FileInputStream(realPath);
//      设置响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);
        System.out.println("2");
//      4.将输入流数据写入到输出流中
        ServletOutputStream servletOutputStream = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while((len = fileInputStream.read(buff)) != -1){
            servletOutputStream.write(buff,0,len);
        }
        fileInputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
