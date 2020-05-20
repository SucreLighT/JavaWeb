package cn.sucre.DAO;

import cn.sucre.Util.JDBCUtils;
import cn.sucre.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author sucre
 * @date 2020-05-20
 * @time 10:31
 * @description 操作数据库中的user表
 */

public class UserDAO {

    //    声明JdbcTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //    登录方法
    public User login(User loginUser) {
        try {
            //      编写sql
            String sql = "select * from user where username = ? and password = ?";
            //      调用query
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
}
