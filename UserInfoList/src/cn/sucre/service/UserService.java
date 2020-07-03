package cn.sucre.service;

import cn.sucre.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 增加用户信息
	 * @param user
	 */
	void addUser(User user);
}
