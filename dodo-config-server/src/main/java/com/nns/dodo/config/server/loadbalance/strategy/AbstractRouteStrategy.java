package com.nns.dodo.config.server.loadbalance.strategy;



import com.nns.dodo.config.server.beans.Server;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Johnny
 * @date 2019/10/27 21:45
 */
public abstract class AbstractRouteStrategy implements RouteStrategy{

    //cpu 利用率阈值
    private static final double CPU_USE_THRESHOLD = 80;

    // load5 的大小阈值
    private static final double LOAD5_THRESHOLD = 4;


    @Override
    public Server execute(List<Server> servers) {

        //过滤掉一些负载重的机器
        servers = servers.stream().filter(server -> {
           return isOverThreshold(server);
        }).collect(Collectors.toList());

        try {
            return doRoute(servers);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            //后面可以规范错误码，记录日志，然后将异常抛出去
            System.out.println("负载均衡策略执行失败");
        }
        return null;

    }

    //
    public abstract Server doRoute(List<Server> servers);


    /**
     * 当前机器是否超过阈值，如果超过不提供服务,暂时以 cpu利用率和load5的值作为标准
     * @param server
     * @return
     */
    private boolean  isOverThreshold(Server server) {

        if (server.getStatus().getCpuUse() >= CPU_USE_THRESHOLD || server.getStatus().getLoad() >= LOAD5_THRESHOLD) {
            return true;
        }
        return false;
    }

}
