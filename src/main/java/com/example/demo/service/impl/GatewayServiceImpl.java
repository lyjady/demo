package com.example.demo.service.impl;

import com.example.demo.entries.Gateway;
import com.example.demo.mapper.GatewayMapper;
import com.example.demo.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:44
 */
@Service
public class GatewayServiceImpl implements GatewayService {

    @Autowired
    private GatewayMapper gatewayMapper;

    /**
     * @return java.util.List<com.example.demo.entries.Gateway>
     * @author LinYongJin
     * @date 2019/8/24 17:54
     * @description 获取网关
     */
    @Override
    public List<Gateway> queryGateway() {
        return gatewayMapper.queryGateway();
    }

    /**
     * @return java.util.List<java.lang.String>
     * @author LinYongJin
     * @date 2019/8/24 17:54
     * @description 计算符合条件的网关
     */
    @Override
    public List<String> computeGateway() {
        List<Gateway> gateways = queryGateway();

        return null;
    }

    @Async
    public void thread() throws InterruptedException {
        System.out.println("current thread name: " + Thread.currentThread().getName());
        Thread.sleep(8000L);
        System.out.println("执行结束");
    }
}
