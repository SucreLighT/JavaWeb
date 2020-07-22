package cn.sucre.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/22
 * @time: 19:11
 */
@WebServlet(urlPatterns = "/FindUserServlet")
public class FindUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		//在服务器端设置MIME类型，表示响应的数据格式为json，等效于客户端中get方法中的最后一个参数设置
		response.setContentType("application/json;charset=utf-8");


		//获取用户名
		String username = request.getParameter("username");

		//简化查询数据库
		Map<String, Object> map = new HashMap<String, Object>();
		if("tom".equals(username)){
			map.put("userExist", true);
			map.put("msg", "用户名存在！");
		}else{
			map.put("userExist", false);
			map.put("msg", "用户名可用！");
		}

		//将map转为json,并将其传递给客户端
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), map);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
