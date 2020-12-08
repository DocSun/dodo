package com.nns.dodo.config.server.beans;

import lombok.Data;

/**
 * @Data注解已覆写equals方法
 */
@Data
public class Server {

    //服务端ip
    public String ip;

    //服务端端口
    public int port;

    //后续可以添加一下服务器的一些状态（比如 load，cpu利用率, 可以用一），用于负载均衡，
    ServerStatus status;
}
