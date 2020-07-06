package cn.sucre.web.servlet;

import cn.sucre.service.UserService;
import cn.sucre.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DelUserServlet")
public class DelUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	1.获取id
		String id = request.getParameter("id");
		//	2.调用service删除
		UserService service = new UserServiceImpl();
		service.deleteUser(id);
		//	3.跳转到用户信息列表
		response.sendRedirect(request.getContextPath() + "/UserListServlet");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
}
