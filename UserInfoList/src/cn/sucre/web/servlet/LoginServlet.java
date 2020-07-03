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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		//2.封装数据
		String verifycode = request.getParameter("verifycode");

		//3.验证码校验
		HttpSession session = request.getSession();
		String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
		//验证码是一次性的，校验之后需要在session中移除该属性
		session.removeAttribute("CHECKCODE_SERVER");

		if(!checkcode_server.equalsIgnoreCase(verifycode)){
			//验证码不正确
			request.setAttribute("login_msg","验证码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}

		Map<String, String[]> map = request.getParameterMap();
		//3.封装User对象
		User user = new User();
		try {
			BeanUtils.populate(user,map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		//5.调用Service查询
		UserService service = new UserServiceImpl();
		User loginUser = service.login(user);

		//6.判断是否登录成功
		if(loginUser != null){
			//登录成功
			//将用户存入session
			session.setAttribute("user",loginUser);
			//request中没有共享数据，这里使用重定向进行跳转
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else{
			//登录失败
			request.setAttribute("login_msg","用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}
}
