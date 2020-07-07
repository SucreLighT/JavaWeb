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

	/**
	 * 根据id删除指定用户信息
	 * @param id
	 */
	void deleteUser(String id);

	/**
	 * 根据id查询用户并获取该对象
	 * @param id
	 * @return
	 */
	User findUserById(String id);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 删除选中的用户信息
	 * @param uids
	 */
	void delSelectedUser(String[] uids);
}
