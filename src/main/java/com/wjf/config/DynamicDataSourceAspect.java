package com.wjf.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * AOP
 * @created by 24745
 * @date 2019/11/11
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(DS)")
    @SuppressWarnings("rawtypes")
    public void beforeSwitches(JoinPoint point) {
        //获取当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获取访问的方法名称
        String methodName = point.getSignature().getName();
        //得到方法的参数类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String datasource = DataSourceContextHolder.DEFAULT_DS;
        try {
            //得到访问的方法对象
            Method method = className.getMethod(methodName,argClass);
            //判断是否存在@DS注解
            if(method.isAnnotationPresent(DS.class)) {
                DS annation = method.getAnnotation(DS.class);
                //取出注解的数据源名
                datasource=annation.value();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(datasource);
    }


    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }

}
