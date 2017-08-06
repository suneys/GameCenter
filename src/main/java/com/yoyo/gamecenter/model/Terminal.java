package com.yoyo.gamecenter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public class Terminal implements Serializable{
    private long tId;                            // 终端id
    private String terminalNo;                   // 终端编号
    private String terminalName;                 //终端名称
    private Short publishState;                  // 发布状态：0-失败，1-成功，2-发布中
    private Short isUpdate;                      // 有无内容更新
    private Date createDate;                    // 注册日期
    private long uId;                            // 绑定用户id
    private Short activation;                    //绑定状态
    private Date activationDate;                 // 绑定日期
    private Date endDate;                        // 截止日期(未注册默认7天有效，预留功能)
    private long agentId;                        // 代理商ID
    private Short isDelete;                      // 是否删除 0-未删除，1-删除
    private Short isOverdue;                     // 是否过期 0-未过期，1-过期
    private String version;                      // 版本号
    private User user;
    private List<Resource> resources;
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long gettId() {
        return tId;
    }

    public void settId(long tId) {
        this.tId = tId;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Short getPublishState() {
        return publishState;
    }

    public void setPublishState(Short publishState) {
        this.publishState = publishState;
    }

    public Short getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Short isUpdate) {
        this.isUpdate = isUpdate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public Short getActivation() {
        return activation;
    }

    public void setActivation(Short activation) {
        this.activation = activation;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Short getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Short isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "tId=" + tId +
                ", terminalNo='" + terminalNo + '\'' +
                ", terminalName='" + terminalName + '\'' +
                ", publishState=" + publishState +
                ", isUpdate=" + isUpdate +
                ", createDate=" + createDate +
                ", uId=" + uId +
                ", activation=" + activation +
                ", activationDate=" + activationDate +
                ", endDate=" + endDate +
                ", agentId=" + agentId +
                ", isDelete=" + isDelete +
                ", isOverdue=" + isOverdue +
                ", version='" + version + '\'' +
                ", user=" + user +
                ", resources=" + resources +
                '}';
    }
}
