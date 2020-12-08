package com.nns.dodo.config.server.service;


import com.nns.dodo.config.server.beans.Server;
import com.nns.dodo.config.server.beans.Service;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Johnny
 * @date 2019/10/27 19:21
 */
@Component
public class ServiceHolderImpl implements ServiceHolder {

    private Map<String, List<Service>> serviceMap = new ConcurrentHashMap<String, List<Service>>();

    @Override
    public void regist(Service service) {

        if (serviceMap.containsKey(service.getServiceName())) {
            List<Service> serviceList = serviceMap.get(service.getServiceName());
             if(serviceList.stream().filter( s -> s.equals(service)).count() > 0) {
                 return;
             }
            serviceList.add(service);
        } else {
            serviceMap.put(service.getServiceName(), new ArrayList<Service>(){{add(service);}});
        }


    }

    @Override
    public Optional<Service> get(ServiceRequest request) {
        return null;
    }


    /**
     * 根据servicename获取其对应的server列表
     * @param serviceName
     * @return
     */
    private List<Server> getServiceServerList(String serviceName) {
        return serviceMap.get(serviceName).stream().map(s -> s.getServer()).distinct().collect(Collectors.toList());
    }
}
