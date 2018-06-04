package com.fqg.cache;

import java.util.Set;

public interface IRedisCache {

    String getValueByKey(String key);

    Set<String> getSetByKey(String key);

    Integer saveString(String key, String value);

    String saveObject(String key, Object obj);

    Integer saveSet(String key, Set<String> set);
}
