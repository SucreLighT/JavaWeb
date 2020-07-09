package cn.sucre.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/09
 * @time: 15:05
 */
@WebFilter(urlPatterns = "/*")
public class Demo1Filter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

		System.out.println("过滤器执行...");
		// 过滤器放行
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
