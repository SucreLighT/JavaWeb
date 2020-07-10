package cn.sucre.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/10
 * @time: 09:03
 */
@WebFilter(urlPatterns = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class Demo2Filter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		System.out.println("过滤器2执行...");
		chain.doFilter(req, resp);
		System.out.println("过滤器2放行...");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
