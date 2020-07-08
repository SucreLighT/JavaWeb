package cn.sucre.web.servlet;

import cn.sucre.domain.PageBean;
import cn.sucre.domain.User;
import cn.sucre.service.UserService;
import cn.sucre.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/UserListByPageServlet")
public class UserListByPageServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 1.获取参数
		String currentPage = request.getParameter("currentPage"); //当前页码
		String rows = request.getParameter("rows"); //每页显示条数


		// 当第一次进入用户信息列表界面时，request中没有这两个属性，分别设置为1和5
		if(currentPage == null || "".equals(currentPage)){
			currentPage = "1";
		}
		if(rows == null || "".equals(rows)){
			rows = "5";
		}

		Map<String, String[]> condition = request.getParameterMap(); // 查询条件

		// 2.调用service查询
		UserService service = new UserServiceImpl();
		PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);

		// 3.将PageBean和查询条件存入request
		request.setAttribute("pb",pb);
		request.setAttribute("condition",condition);

		// System.out.println(pb);
		// 4. 跳转页面
		request.getRequestDispatcher("/list.jsp").forward(request,response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
}
