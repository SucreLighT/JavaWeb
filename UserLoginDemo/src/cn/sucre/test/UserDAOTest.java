package cn.sucre.test;

import cn.sucre.DAO.UserDAO;
import cn.sucre.domain.User;
import org.junit.Test;

/**
 * @author sucre
 * @date 2020-05-20
 * @time 10:49
 * @description
 */
public class UserDAOTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");

        UserDAO dao = new UserDAO();
        User user = dao.login(loginuser);
        System.out.println(user);

    }
}
