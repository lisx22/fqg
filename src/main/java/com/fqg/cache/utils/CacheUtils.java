package com.fqg.cache.utils;

public class CacheUtils {
    //规范KEY的格式： user_id_1
    private static String headers = "user,product,shoppingcart";
    public static final String REGEX = "^[a-z]{3,9}_[a-z]{2,9}_[0-9a-z]{1,10}$";

    /**
     * 判断key的规范性
     * @param key
     * @return
     */
    public static boolean detectKey(String key) {
        if (key == null) {
            return false;
        }
        if (key.matches(REGEX)) {
            String[] split = key.split("_");
            if (headers.contains(split[0])) {
                return true;
            }

        }

        return false;
    }
}
