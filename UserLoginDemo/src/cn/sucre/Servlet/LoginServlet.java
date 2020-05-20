package cn.sucre.Servlet;

import cn.sucre.DAO.UserDAO;
import cn.sucre.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      设置编码
        request.setCharacterEncoding("utf-8");
//
////      获取请求参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
////      封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

//      使用map集合和BeanUtils获取所有请求参数
        Map<String,String[]> map = request.getParameterMap();
        User loginUser = new User();

        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//      调用UserDAO进行login
        UserDAO userDAO = new UserDAO();
        User user = userDAO.login(loginUser);

//      根据返回的user判断登录情况
        if(user == null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}
