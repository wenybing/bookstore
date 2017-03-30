package com.yr.bookstore;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/2/15.
 */

/**
 * 实例工厂类
 */
public class FilterChainDefinitionMapFactory {
    public LinkedHashMap<String,String> filterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        /**
         * 从数据表中获取权限初始化map
         *
         *  /shiro/logout = logout
            /jsp/pages/manager/order_manager.jsp = authc
            /book/findBook = authc
            /jsp/pages/cart/cart.jsp = authc
            /jsp/pages/manager/manager.jsp = authc
         # everything else requires authentication:
         */
        map.put("/jsp/pages/cart/cart.jsp","anon");
        map.put("/jsp/pages/manager/order_manager.jsp","authc,roles[user]");
        map.put("/jsp/pages/manager/manager.jsp","authc,roles[admin]");

        return map;
    }
}
