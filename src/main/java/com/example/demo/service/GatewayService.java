package com.example.demo.service;

import com.example.demo.entries.Gateway;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:43
 */
public interface GatewayService {

    /**
    * @author LinYongJin
    * @return java.util.List<com.example.demo.entries.Gateway>
    * @date 2019/8/24 17:54
    * @description 获取网关
    */
    List<Gateway> queryGateway();

    /**
    * @author LinYongJin
    * @return java.util.List<java.lang.String>
    * @date 2019/8/24 17:54
    * @description 计算符合条件的网关
    */
    List<String> computeGateway();
}
