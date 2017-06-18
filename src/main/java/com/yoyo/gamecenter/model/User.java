package com.yoyo.gamecenter.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public class User {

    private Long id;
    private String userName;    //用户名
    private String userPhone;   //用户电话
    private String userEmail;   //用户邮箱
    private String userPwd;     //加密用户密码
    private Short userRole;     //用户角色   0-普通用户，1-代理商，2-超级用户
    private Date createTime;    //创建时间
    private Date modifyTime;    //最后修改时间
    private Short isDelete;     //是否删除，0-未删除；1-已删除
    private Short isEnable;     //是否可用，0-不可用；1-可用
    private int daySend;        //当天发送的数量
    private int totalSend;      //总共发送的数量
    private int totalSize;      //分配的容量，默认是500M
    private int uploadSize;     //上传已用的容量
    private String logoPath;    //企业logo路径

    private Long userOutDate;   //找回密码的过期时间
    private String userSecretKey;   //找回密码的密钥
    private List<Terminal> terminals;   //绑定的终端
    private List<Resource> resources;   //上传的资源
    private List<AdvFolder> advFolders; //用户的文件夹

    public List<AdvFolder> getAdvFolders() {
        return advFolders;
    }

    public void setAdvFolders(List<AdvFolder> advFolders) {
        this.advFolders = advFolders;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public Long getUserOutDate() {
        return userOutDate;
    }

    public void setUserOutDate(Long userOutDate) {
        this.userOutDate = userOutDate;
    }

    public String getUserSecretKey() {
        return userSecretKey;
    }

    public void setUserSecretKey(String userSecretKey) {
        this.userSecretKey = userSecretKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Short getUserRole() {
        return userRole;
    }

    public void setUserRole(Short userRole) {
        this.userRole = userRole;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public int getDaySend() {
        return daySend;
    }

    public void setDaySend(int daySend) {
        this.daySend = daySend;
    }

    public int getTotalSend() {
        return totalSend;
    }

    public void setTotalSend(int totalSend) {
        this.totalSend = totalSend;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getUploadSize() {
        return uploadSize;
    }

    public void setUploadSize(int uploadSize) {
        this.uploadSize = uploadSize;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRole=" + userRole +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", isDelete=" + isDelete +
                ", isEnable=" + isEnable +
                ", daySend=" + daySend +
                ", totalSend=" + totalSend +
                ", userOutDate=" + userOutDate +
                ", userSecretKey='" + userSecretKey + '\'' +
                ", terminals=" + terminals +
                '}';
    }
}
