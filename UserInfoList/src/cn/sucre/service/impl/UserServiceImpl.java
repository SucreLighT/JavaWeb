package cn.sucre.service.impl;

import cn.sucre.dao.UserDao;
import cn.sucre.dao.impl.UserDaoImpl;
import cn.sucre.domain.PageBean;
import cn.sucre.domain.User;
import cn.sucre.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if(uids != null && uids.length > 0){
            // 1.遍历数组
            for (String id: uids
            ) {
                // 2.调用到删除
                dao.deleteUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int _currentPage = Integer.parseInt(currentPage);
        int _rows = Integer.parseInt(rows);

        // 当前页为第一页时，点击上一页按钮会导致该值为负数，此时重置其值为1，
        // 即在第一页时点击上一页仍然保持在第一页
        if(_currentPage <= 0){
            _currentPage = 1;
        }

        // 调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        // 计算总页码
        int totalPage = (totalCount%_rows) == 0 ? (totalCount/_rows) : (totalCount/_rows) + 1;

        // 当前页为最后一页，点击下一页时，设置该值为最后一页
        if(_currentPage > totalPage){
            _currentPage = totalPage;
        }

        // 调用dao查询list集合
        // 计算当前页面记录在数据库中对应的开始索引
        int start = (_currentPage - 1)*_rows;
        List<User> list = dao.findByPage(start,_rows,condition);

        // 创建PageBean对象
        PageBean<User> pb = new PageBean<User>();

        // 设置参数
        pb.setCurrentPage(_currentPage);
        pb.setRows(_rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);

        return pb;
    }
}
