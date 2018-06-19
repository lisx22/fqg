package com.fqg.util;

public class SystemParam {
    /**
     * 登录的用户提示信息
     */
    public final static class Login {
        /**
         * 登录成功提示
         */
        public static final int CODE_SUCCESS = 0;
        public static final String MSG_SUCCESS="登录成功";

        public static final int CODE_FAIL_UNKOWN_ACCOUNT = 1;
        public static final String MSG_FAIL_UNKOWN_ACCOUNT="手机号错误";

        public static final int CODE_FAIL_INCORRECT_PASSWORD = 2;
        public static final String MSG_FAIL_INCORRECT_PASSWORD="密码错误";

        public static final int SAVE = 4;
        public static final String SAVE2="注册失败";

        public static final int SAVE3 = 5;
        public static final String SAVE4="验证码错误";
    }
}