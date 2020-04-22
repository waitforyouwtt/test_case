package com.example.demo.ticket.brush;

import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/4/10 17:16
 * @Email: 15290810931@163.com
 */
@Data
public class IpInfo {

    private String ipAddress;
    private int port;
    private String location;
    private String anonymousType;
    private String type;
    private String confirmTime;
    private String getPostSupport;
    private String responseSpeed;


    public IpInfo(String ipAddress, int port, String location,
                  String anonymousType, String type, String confirmTime) {
        this(ipAddress, port, location, anonymousType, type, confirmTime, null,
                null);
    }

    public IpInfo(String ipAddress, int port, String location,
                  String anonymousType, String type, String confirmTime,
                  String getPostSupport, String responseSpeed) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.location = location;
        this.anonymousType = anonymousType;
        this.type = type;
        this.confirmTime = confirmTime;
        this.getPostSupport = getPostSupport;
        this.responseSpeed = responseSpeed;
    }


    @Override
    public boolean equals(Object anthor) {
        if (this == anthor) {
            return true;
        }
        if (anthor == null || getClass() != anthor.getClass()) {
            return false;
        }

        IpInfo ipInfo = (IpInfo) anthor;
        return (this.ipAddress.equals(ipInfo.ipAddress)
                && this.port == ipInfo.port
                && this.location.equals(ipInfo.location)
                && this.anonymousType.equals(ipInfo.anonymousType)
                && this.type.equals(ipInfo.type) && this.confirmTime
                .equals(ipInfo.confirmTime))
                && this.getPostSupport.equals(ipInfo.getPostSupport)
                && this.responseSpeed.equals(ipInfo.responseSpeed);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash
                + (this.ipAddress != null ? this.ipAddress.hashCode() : 0);
        hash = 89 * hash + this.port;
        hash = 89 * hash
                + (this.location != null ? this.location.hashCode() : 0);
        hash = 89
                * hash
                + (this.anonymousType != null ? this.anonymousType.hashCode()
                : 0);
        hash = 89 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 89 * hash
                + (this.confirmTime != null ? this.confirmTime.hashCode() : 0);
        hash = 89
                * hash
                + (this.getPostSupport != null ? this.getPostSupport.hashCode()
                : 0);
        hash = 89
                * hash
                + (this.responseSpeed != null ? this.responseSpeed.hashCode()
                : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ipAddress = " + ipAddress + ", port = " + port + ", localtion = "
                + location + ", anonymousType = " + anonymousType + ", type = "
                + type + ", confirmTime = " + confirmTime + ", getPostSupport = "
                + getPostSupport + ", responseSpeed = " + responseSpeed;
    }


}
