package com.fqg.util;
public class SystemTools {
    /**
     * 利用工厂方法完成返回结果的格式化
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult formatJsonResult(int code,String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }
}
