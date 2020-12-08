package com.nns.dodo.config.server.service;


import com.nns.dodo.config.server.beans.Service;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * @author Johnny
 * @date 2019/10/27 19:17
 */
public interface ServiceHolder {

    /**
     * 服务注册，服务端的注册到config-server
     */
    public void regist(@NotNull Service service);


    public Optional<Service> get(ServiceRequest request);

}
