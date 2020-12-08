package com.nns.dodo.config.server.beans;

import lombok.Data;

/**
 * @author Johnny
 * @date 2019/10/26 22:03
 *
 * 保存注册在configserver的服务的实体对象
 * @Data注解已覆写equals方法
 */

@Data
public class Service {

    private Server server;

    private String serviceName;  //包名+类名的方式

    private String serviceGroup;

    private String serviceVersion;
}
