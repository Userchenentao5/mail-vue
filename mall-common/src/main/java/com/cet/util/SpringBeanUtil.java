package com.cet.util;

import org.springframework.context.ApplicationContext;

/**
 * Spring工具类
 *
 * @author 苏三，该项目是知识星球：java突击队 的内部项目
 * @date 2024/1/12 下午1:38
 */
public class SpringBeanUtil {

    public static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    /**
     * 根据名称获取bean实例
     *
     * @param name 名称
     * @param <T>  泛型
     * @return bean实例
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 根据类型获取bean实例
     *
     * @param requiredType 类型
     * @param <T>          泛型
     * @return bean实例
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }
}
