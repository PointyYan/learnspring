package com.smart.dao;

import com.smart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 14:34 2018/4/30
 * @Modified By:
 */
@Repository
public class UserDao extends BaseDao<User> {

    private static final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";

    private static final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";

    /**
     * Description: 根据用户名查询User对象
     *
     * @param: userName 用户名
     * @return: 返回一个User对象
     */
    public User getUserByUserName(String userName) {
        List<User> list = (List<User>) this.getHibernateTemplate().find(GET_USER_BY_USERNAME, userName);
        if (list.size() == 0) {
            return null;
        }else {
            return list.get(0);
        }
    }

    /**
     * Description: User模糊查询
     * @param: userName
     * @return:
     */
    public List<User> queryUserByUserName(String userName) {
        return (List<User>) getHibernateTemplate().find(QUERY_USER_BY_USERNAME, userName);
    }
}
