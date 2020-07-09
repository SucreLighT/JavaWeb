package cn.sucre.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/09
 * @time: 16:46
 */
@WebServlet(urlPatterns = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理响应乱码问题:字节流需getBytes("UTF-8")
		response.setContentType("text/html;charset=UTF-8");
		// 处理post请求乱码问题
		request.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
