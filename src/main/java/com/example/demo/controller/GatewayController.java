package com.example.demo.controller;

import com.example.demo.entries.Gateway;
import com.example.demo.entries.Signal;
import com.example.demo.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:45
 */
@RestController
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    public static Map<String, Signal> entries = new HashMap<>();

    public static List<Gateway> gateways = new ArrayList<>();

    public static List<String> lineGateway = new ArrayList<>();

    static {
        Signal a1 = new Signal("A1", -34);
        Signal a2 = new Signal("A2", -23);
        Signal a3 = new Signal("A3", -41);
        Signal a4 = new Signal("A4", -53);
        Signal a5 = new Signal("A5", -42);
        Signal a6 = new Signal("A6", -29);
        Signal a7 = new Signal("A7", -56);
        Signal a8 = new Signal("A8", -41);
        Signal a9 = new Signal("A9", -39);
        Signal a10 = new Signal("A10", -88);
        entries.put("A3", a3);
        entries.put("A1", a1);
        entries.put("A4", a4);
        entries.put("A2", a2);
        entries.put("A5", a5);
        entries.put("A6", a6);
        entries.put("A7", a7);
        entries.put("A8", a8);
        entries.put("A9", a9);
        entries.put("A10", a10);
        System.out.println(entries);
    }

    @RequestMapping("/gateway")
    public List<Gateway> queryGateway() {
        gateways = gatewayService.queryGateway();
        gatewayService.computeGateway();
        return null;
    }
}
