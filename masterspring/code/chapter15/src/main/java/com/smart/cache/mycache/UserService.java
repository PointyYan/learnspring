package com.smart.cache.mycache;

import com.smart.cache.domain.User;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 11:25 2018/4/23
 * @Modified By:
 */
public class UserService {

    private CacheManager<User> cacheManager;

    public UserService() {
        //构造一个缓存管理器
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {

        //首先查询缓存
        User result = cacheManager.getValue(userId);
        if (result != null) {
            System.out.println("get from cache..." + userId);
            //如果在缓存中，则直接返回缓存的结果
            return result;
        }

        //否则就需要在数据库中查询
        result = getFromDB(userId);
        if (result != null) {
            //将数据库查询的结果更新到缓存中
            cacheManager.addOrUpdateCache(userId,result);
        }
        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
