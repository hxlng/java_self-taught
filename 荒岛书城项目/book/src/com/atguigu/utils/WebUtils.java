package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author xfy
 * @create 2021-09-01 23:06
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value,T bean){
        try {
            System.out.println("注入之前："+bean);
            /*
            * 把所有请求的参数都注入到user对象中
            * */
            BeanUtils.populate(bean,value);
            System.out.println("注入之后："+bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化成为int类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
