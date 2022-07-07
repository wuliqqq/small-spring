package org.asher.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/26
 * \* Description:
 * \
 */
public class UserDao {

    private static Map<String,String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001","AsherWu1");
        hashMap.put("1002","AsherWu2");
        hashMap.put("1003","AsherWu3");

    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}

