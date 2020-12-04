package com.nns.dodo.common.annotation.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author Johnny
 * @date 2019/10/26 22:43
 * rpc框架提供的注解的类型
 */
public enum AnnotationTypeEnum {

    RPC_SERVIEC_PROVIDER("RPC_SERVIEC_PROVIDER", "服务提供者"),
    RPC_SERVICE_CONSUMER("RPC_SERVICE_CONSUMER", "服务消费者");

    @Getter
    private String code;

    @Getter
    private String desc;

    AnnotationTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Enum valueOf(Class clazz, String code) {
        try {
            return Enum.valueOf(clazz, code);
        } catch (Exception e) {
            System.out.println(String.format("cant serialize the enum: %s, value: %s ", clazz.getName(), code));
            return null;
        }
    }

    public static AnnotationTypeEnum of(String code) {
        for (AnnotationTypeEnum annotationTypeEnum : AnnotationTypeEnum.values()) {
            if (annotationTypeEnum.getCode().equals(code)) {
                return annotationTypeEnum;
            }
        }
        return null;
    }
}
