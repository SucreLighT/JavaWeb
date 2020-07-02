package cn.sucre.service.impl;

import cn.sucre.dao.UserDao;
import cn.sucre.dao.impl.UserDaoImpl;
import cn.sucre.domain.User;
import cn.sucre.service.UserService;

import java.util.List;

/**
 * @author sucre
 * @date 2020-07-02
 * @time 15:13
 * @description
 */
public class UserServiceImpl  implements UserService {

    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao中的方法完成查询
        return dao.findAll();
    }
}
