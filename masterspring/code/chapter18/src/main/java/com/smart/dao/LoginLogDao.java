package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 14:33 2018/4/30
 * @Modified By:
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {

    public void save(LoginLog loginLog) {
        this.getHibernateTemplate().save(loginLog);
    }
}
