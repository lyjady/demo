package com.example.demo.entries;

/**
 * @author LinYongJin
 * @date 2019/8/24 17:39
 */
public class Gateway {

    private String mac;

    private double x;

    private double y;

    private double median;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "mac='" + mac + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", median=" + median +
                '}';
    }
}
