package com.shemuel.model;

import java.util.Arrays;

public class VisitLog {
    private String time;
    private String id;
    private String browseType;
    private String address;
    private String ip;
    private String url;
    private String computerName;
    private String operateSystem;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrowseType() {
        return browseType;
    }

    public void setBrowseType(String browseType) {
        this.browseType = browseType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }


    public String getOperateSystem() {
        return operateSystem;
    }

    public void setOperateSystem(String operateSystem) {
        this.operateSystem = operateSystem;
    }

    @Override
    public String toString() {
        return "VisitLog{" +
                "time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", browseType='" + browseType + '\'' +
                ", address='" + address + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", computerName=" + computerName +
                ", operateSystem='" + operateSystem + '\'' +
                '}';
    }
}
