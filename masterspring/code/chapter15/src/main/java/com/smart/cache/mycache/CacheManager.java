package com.smart.cache.mycache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 10:54 2018/4/23
 * @Modified By:
 */
public class CacheManager<T> {
    private Map<String, T> cache = new ConcurrentHashMap<String, T>();

    public T getValue(Object key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    public void evictCache() {
        cache.clear(); //清空缓存中的记录
    }

}
