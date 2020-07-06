package cn.sucre.dao.impl;

import cn.sucre.dao.UserDao;
import cn.sucre.domain.User;
import cn.sucre.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author sucre
 * @date 2020-07-02
 * @time 15:15
 * @description
 */
public class UserDaoImpl implements UserDao {

    //连接数据库
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        // 1.定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        // 2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void deleteUser(int parseInt) {
        // 1.定义sql
        String sql = "delete from user where id = ?";
        // 2.执行sql
        template.update(sql,parseInt);
    }
}
