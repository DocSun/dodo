package com.nns.dodo.common.annotation.scan;


import com.nns.dodo.common.annotation.enums.AnnotationTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author Johnny
 * @date 2019/10/26 21:58
 */
@Component
public class RPCConsumerSpringBeanScanner extends AbstractRPCSpringBeanScanner {

    @Override
    public void doScan() {

    }


    @Override
    public AnnotationTypeEnum getAnnotationType() {
        return null;
    }
}
