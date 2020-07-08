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

	/**
	 * 根据id查找用户
	 * @param parseInt
	 * @return
	 */
	User findById(int parseInt);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 查询总记录数
	 * @return
	 */
	int findTotalCount();

	/**
	 * 分页查询每页记录
	 * @param start 当前页在数据库中起始索引
	 * @param rows 每一页固定的记录数
	 * @return
	 */
	List<User> findByPage(int start, int rows);
}
