package com.xfn.dbLog.entity;

/**
 * Created by po on 16/8/17.
 */
public class OperationLog {
    /*  日志主键  */
    private int logKey;

    /*  日志开始时间  */
    private String startTime;

    /*  持续时间  */
    private double durationTime;

    /*  用户名称  */
    private String userName;

    /*  用户id  */
    private String userID;

    /*  帐套名称  */
    private String sobName;

    /*  帐套id  */
    private String sobID;

    /*  公司名称  */
    private String corpName;

    /*  公司id  */
    private String corpID;

    /*  操作业务名称  */
    private String bussinessType;

    /*  操作类型（增上改查）  */
    private String operationtype;

    /*  返回状态码  */
    private String returncode;

    /*  具体操作内容  */
    private String comments;

    private String source;

    private String useruuid;

    private String serviceIP;

    private String servicePort;

    private String appId;

    public int getLogKey() {
        return logKey;
    }

    public void setLogKey(int logKey) {
        this.logKey = logKey;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime = durationTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSobName() {
        return sobName;
    }

    public void setSobName(String sobName) {
        this.sobName = sobName;
    }

    public String getSobID() {
        return sobID;
    }

    public void setSobID(String sobID) {
        this.sobID = sobID;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpID() {
        return corpID;
    }

    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUseruuid() {
        return useruuid;
    }

    public void setUseruuid(String useruuid) {
        this.useruuid = useruuid;
    }

    public String getServiceIP() {
        return serviceIP;
    }

    public void setServiceIP(String serviceIP) {
        this.serviceIP = serviceIP;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "logKey=" + logKey +
                ", startTime='" + startTime + '\'' +
                ", durationTime=" + durationTime +
                ", userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", sobName='" + sobName + '\'' +
                ", sobID='" + sobID + '\'' +
                ", corpName='" + corpName + '\'' +
                ", corpID='" + corpID + '\'' +
                ", bussinessType='" + bussinessType + '\'' +
                ", operationtype='" + operationtype + '\'' +
                ", returncode='" + returncode + '\'' +
                ", comments='" + comments + '\'' +
                ", source='" + source + '\'' +
                ", useruuid='" + useruuid + '\'' +
                ", serviceIP='" + serviceIP + '\'' +
                ", servicePort='" + servicePort + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
