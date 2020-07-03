package cn.sucre.web.servlet;

import cn.sucre.domain.User;
import cn.sucre.service.UserService;
import cn.sucre.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	1.设置编码
		request.setCharacterEncoding("utf-8");
	//	2.获取参数
		Map<String, String[]> map = request.getParameterMap();
	//	3.封装对象
		User user = new User();
		try {
			BeanUtils.populate(user,map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 4.调用service方法保存
		UserService service = new UserServiceImpl();
		service.addUser(user);
	//	跳转到用户信息列表页面
		response.sendRedirect(request.getContextPath() + "/UserListServlet");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
}
