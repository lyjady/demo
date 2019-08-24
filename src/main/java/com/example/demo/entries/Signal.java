package com.example.demo.entries;

import java.util.Comparator;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:41
 */
public class Signal implements Comparable<Signal> {

    private String mac;

    private double medina;

    public Signal(String mac, double medina) {
        this.mac = mac;
        this.medina = medina;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public double getMedina() {
        return medina;
    }

    public void setMedina(double medina) {
        this.medina = medina;
    }

    @Override
    public int compareTo(Signal o) {
       if (this.medina > o.medina) {
           return 1;
       } else {
           return -1;
       }
    }

    @Override
    public String toString() {
        return "Signal{" +
                "mac='" + mac + '\'' +
                ", medina=" + medina +
                '}';
    }
}
