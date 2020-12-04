package loadbalance.strategy;


import com.johnny.rpc.config.beans.Server;

import java.util.List;

/**
 * 轮询的负载均衡策略
 */
public class RoundRouteStrategy extends AbstractRouteStrategy{

    @Override
    public Server doRoute(List<Server> servers) {
        return null;
    }


}
