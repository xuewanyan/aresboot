package com.cn.ascept;

import com.cn.annotation.Treat;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * aop
 */
@Component
@Aspect
@Slf4j
public class ServiceAscept {

    @After("execution(* com.cn..service..*.*(..))")
    public Object aroundInvoke(JoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Class<?> clazz = Class.forName(joinPoint.getSignature().getDeclaringTypeName());
        Method method[] = clazz.getMethods();
        PropertyDescriptor propertyDescriptor = null;
        for (Method method1 : method) {
            Parameter[] parameter = method1.getParameters();
            for (int i = 0; i < parameter.length; i++) {
                if (parameter[i].isAnnotationPresent(Treat.class)) {
                    Class<?> clazz2= parameter[i].getType();
                    removeSpace(args[i], clazz2);
                }
            }
        }
        log.info("[obj======]结束,{}", args);
        return args;
    }

    public <T> T removeSpace(Object obj, Class<?> calzz) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] files = calzz.getDeclaredFields();
        PropertyDescriptor propertyDescriptor = null;
        try {
            for (Field file : files) {
                propertyDescriptor = new PropertyDescriptor(file.getName(), calzz);
                Method method = propertyDescriptor.getReadMethod();
                Object objj = method.invoke(obj);
                Method setMeth = propertyDescriptor.getWriteMethod();
                setMeth.invoke(obj, String.valueOf(objj).replaceAll(" ",""));
            }
        } catch (Exception e) {
            log.error("======{}", e);
        }
        return (T) obj;
    }

}
