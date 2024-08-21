package com.zsc.hines.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地服务注册器
 */
public class LocalRegistry {

    //使用ConcurrentHashMap存储服务注册信息，key为服务名称，value为服务的实现类
    private static final Map<String,Class<?>> map = new ConcurrentHashMap<>();

    /**
     * 注册服务（调用该方法将对外暴露的服务注册进map中）
     * @param serviceName
     * @param implClass
     */
    public static void register(String serviceName,Class<?> implClass){
        map.put(serviceName,implClass);
    }

    /**
     * 获取服务
     * @param serviceName
     * @return
     */
    public static Class<?> get(String serviceName){
        return map.get(serviceName);
    }

    public static void delete(String serviceName){
        map.remove(serviceName);
    }
}
