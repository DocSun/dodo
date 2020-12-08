package com.nns.dodo.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RPCConsumer {

    Class<?> seviceInterface();

    String serviceVersion() default "";

    String serviceGroup() default "";

}
