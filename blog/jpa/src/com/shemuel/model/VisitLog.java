package com.shemuel.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "VISIT_LOG", schema = "myproject", catalog = "")
public class VisitLog {
    private Timestamp time;
    private String id;
    private String browseType;
    private String address;
    private String ip;
    private String url;
    private byte[] computerName;
    private String operateSystem;

    @Basic
    @Column(name = "TIME", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitLog visitLog = (VisitLog) o;
        return Objects.equals(time, visitLog.time) &&
                Objects.equals(id, visitLog.id) &&
                Objects.equals(browseType, visitLog.browseType) &&
                Objects.equals(address, visitLog.address) &&
                Objects.equals(ip, visitLog.ip) &&
                Objects.equals(url, visitLog.url) &&
                Arrays.equals(computerName, visitLog.computerName) &&
                Objects.equals(operateSystem, visitLog.operateSystem);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(time, id, browseType, address, ip, url, operateSystem);
        result = 31 * result + Arrays.hashCode(computerName);
        return result;
    }
}
