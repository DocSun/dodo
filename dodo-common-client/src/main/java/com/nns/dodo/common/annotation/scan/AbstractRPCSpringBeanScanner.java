package com.nns.dodo.common.annotation.scan;

import com.nns.dodo.common.annotation.enums.AnnotationTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;

public abstract class AbstractRPCSpringBeanScanner implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Annotation [] annotations = bean.getClass().getAnnotations();
        for (Annotation annotation : annotations) {

        }

        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    /**
     * 扫描注解，获取相关bean
     * 主要是两种：
     * 服务注册者：@PRCProvier; 服务消费者：@RPCConsumer
     */
    public abstract void doScan();


    public abstract AnnotationTypeEnum getAnnotationType();
}
