package com.smart.cache.simplecache;

import com.smart.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 13:33 2018/4/23
 * @Modified By:
 */
@Service(value = "userServiceBean")
public class UserService {

    //使用一个名为users的缓存
    @Cacheable(cacheNames = "users")
    public User getUserById(String userId) {

        System.out.println("real querying user." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
