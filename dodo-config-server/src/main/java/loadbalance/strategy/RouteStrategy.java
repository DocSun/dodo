package loadbalance.strategy;

import com.johnny.rpc.config.beans.Server;

import java.util.List;

/**
 * @author Johnny
 * @date 2019/10/27 21:45
 */
public interface RouteStrategy {

    /**
     * 执行负载策略
     */
    Server execute(List<Server> servers);
}
