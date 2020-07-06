package cn.sucre.dao;

import cn.sucre.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {

	/**
	 * 查询所有用户信息
	 * @return
	 */
    public List<User> findAll();

	/**
	 * 根据用户名和密码判断用户登录是否成功
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByUsernameAndPassword(String username, String password);

	/**
	 * 增加用户信息
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 删除指定id的用户信息
	 * @param parseInt
	 */
	void deleteUser(int parseInt);
}
