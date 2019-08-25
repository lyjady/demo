package com.example.demo;

import com.example.demo.controller.GatewayController;
import com.example.demo.entries.Gateway;
import com.example.demo.entries.Signal;
import com.example.demo.service.GatewayService;
import com.example.demo.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private GatewayService gatewayService;

    @Test
    public void contextLoads() {
        GatewayController.gateways = gatewayService.queryGateway();
        List<Map.Entry<String, Signal>> list = new ArrayList<>(GatewayController.entries.entrySet());
        List<String> dev = new ArrayList<>();
        List<double[]> doubles = CommonUtils.computeTop3Gateway(list, dev);
        dev.removeAll(dev);
        for (double[] point : doubles) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
    }

    @Test
    public void testRedis() {
        ListOperations<String, String> list = template.opsForList();
        List<String> dev = list.range("dev", 0, -1);
        System.out.println(dev == null);
        System.out.println(dev);
    }

}
