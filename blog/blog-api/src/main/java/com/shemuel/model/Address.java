package com.shemuel.model;

import java.io.Serializable;

/*
 * @Description: ip地址信息
 * @Author: Shemuel Deng
 * @Date: 2019/4/25 16:14
 */
public class Address implements Serializable {
    private String ip;
    private String country;
    private String region;
    private String city;
    private String isp;

    public String getIp() {
        return ip;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getIsp() {
        return isp;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    @Override
    public String toString() {
        return country + region + city + isp;
    }
}
