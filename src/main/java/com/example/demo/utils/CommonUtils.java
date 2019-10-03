package com.example.demo.utils;

import com.example.demo.controller.GatewayController;
import com.example.demo.entries.Gateway;
import com.example.demo.entries.Signal;

import java.util.*;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:58
 */
public class CommonUtils {

    public static List<double[]> computeTop3Gateway(List<Map.Entry<String, Signal>> list, List<String> dev) {
        System.out.println("list size: " + list.size());
        System.out.println("line size: " + dev.size());

        list.sort(new Comparator<Map.Entry<String, Signal>>() {
            @Override
            public int compare(Map.Entry<String, Signal> o1, Map.Entry<String, Signal> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < dev.size(); j++) {
                if (list.get(i).getKey().equals(dev.get(j))) {
                    list.remove(i);
                    i--;
                }
            }
        }

        double[] point1 = getGatewayPoints(list.get(0).getKey());
        double[] point2 = getGatewayPoints(list.get(1).getKey());
        double[] point3 = getGatewayPoints(list.get(2).getKey());

        if ((point1[0] == point2[0] && point2[0] == point3[0]) || (point1[1] == point2[1] && point2[1] == point3[1])) {
            System.out.println("在同一条直线上");
            dev.add(list.get(2).getKey());
            List<double[]> doubles = computeTop3Gateway(list, dev);
            return doubles;
        } else {
            List<double[]> l = new ArrayList<>();
            l.add(point1);
            l.add(point2);
            l.add(point3);
            return l;
        }
    }

    public static double[] getGatewayPoints(String mac) {
        double[] point = new double[2];
        for (Gateway gateway : GatewayController.gateways) {
            if (gateway.getMac().equals(mac)) {
                point[0] = gateway.getX();
                point[1] = gateway.getY();
            }
        }
        return point;
    }
}
