package cn.sucre.web.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: 完成登录验证的过滤器
 * @author: sucre
 * @date: 2020/07/10
 * @time: 09:10
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;

		String uri = request.getRequestURI();
		// 排除登录相关的资源，包括css等样式
		if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/")
				|| uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/CheckCodeServlet")) {
			chain.doFilter(req, resp);
		} else {
			// 对于非登录相关资源，判断当前是否登录
			Object user = request.getSession().getAttribute("user");
			//已经登录，直接放行
			if (user != null) {
				chain.doFilter(req, resp);
			} else {
				//跳转到登录页面
				request.setAttribute("login_msg", "您尚未登录，请先登录！");
				request.getRequestDispatcher("/login.jsp").forward(request, resp);
			}
		}
		// chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
