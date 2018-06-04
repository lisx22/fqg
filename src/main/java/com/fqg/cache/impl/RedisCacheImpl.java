package com.fqg.cache.impl;



import com.fqg.cache.IRedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Set;

@Repository
public class RedisCacheImpl implements IRedisCache {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 缓存的所有数据都应该有过期时间
     * @param key
     * @return
     */

    public String getValueByKey(String key) {

        return redisTemplate.boundValueOps(key).get();
    }

    @Override
    public Set<String> getSetByKey(String key) {
        return redisTemplate.boundSetOps(key).members();
    }

    @Override
    public Integer saveString(String key, String value) {

        return redisTemplate.boundValueOps(key).append(value);
    }

    @Override
    public String saveObject(String key, Object obj) {
        //redisTemplate.boundHashOps(key).
        return null;
    }

    @Override
    public Integer saveSet(String key, Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            redisTemplate.boundSetOps(key).add(next);
        }
        return 0;
    }
}
