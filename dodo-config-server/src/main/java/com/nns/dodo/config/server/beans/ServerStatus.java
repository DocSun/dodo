package com.nns.dodo.config.server.beans;

import lombok.Data;

/**
 * @author Johnny
 * @date 2019/10/27 21:42
 *
 * 服务器的状态，这只是其中一些指标，用于负载均衡，可以用单独的一个线程来更新服务器的状态。
 */
@Data
public class ServerStatus {

    private double load;

    private double threadNum;

    private double cpuUse;
}
