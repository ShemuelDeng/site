package com.shemuel.model;

import javax.persistence.*;

@Entity
@Table(name = "VISIT_LOG", schema = "myproject", catalog = "")
public class VisitLog {
    private String time;
    private String id;
    private String browseType;
    private String address;
    private String ip;
    private String url;
    private byte[] computerName;
    private String operateSystem;

    @Basic
    @Column(name = "TIME", nullable = true)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Id
    @Column(name = "ID", nullable = false, length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BROWSE_TYPE", nullable = true, length = 10)
    public String getBrowseType() {
        return browseType;
    }

    public void setBrowseType(String browseType) {
        this.browseType = browseType;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 500)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "IP", nullable = true, length = 64)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "URL", nullable = true, length = 64)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "COMPUTER_NAME", nullable = true)
    public byte[] getComputerName() {
        return computerName;
    }

    public void setComputerName(byte[] computerName) {
        this.computerName = computerName;
    }

    @Basic
    @Column(name = "OPERATE_SYSTEM", nullable = true, length = 64)
    public String getOperateSystem() {
        return operateSystem;
    }

    public void setOperateSystem(String operateSystem) {
        this.operateSystem = operateSystem;
    }
}
