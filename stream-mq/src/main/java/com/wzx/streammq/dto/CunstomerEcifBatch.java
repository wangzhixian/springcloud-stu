package com.wzx.streammq.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ecif同步批次表
 */
public class CunstomerEcifBatch implements Serializable {
    /**
     * uuid主键
     */
    private String ecifBatchId;

    /**
     * 唯一序号
     */
    private String seqNo;

    /**
     * 接口号
     */
    private String serviceCode;

    /**
     * 发送时间,格式：yyyyMMddHHmmss
     */
    private String sendDate;

    /**
     * 总条数
     */
    private Integer ecifBatchCount;

    /**
     * 存储成功条数
     */
    private Integer ecifBatchSuccessNum;

    /**
     * 存储失败条数
     */
    private Integer ecifBatchErrorNum;

    /**
     * 是否删除：0 未删除  1 已删除  默认为0
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人id
     */
    private Integer createdUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人ID
     */
    private Integer updateUser;


    public String getEcifBatchId() {
        return ecifBatchId;
    }

    public void setEcifBatchId(String ecifBatchId) {
        this.ecifBatchId = ecifBatchId;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getEcifBatchCount() {
        return ecifBatchCount;
    }

    public void setEcifBatchCount(Integer ecifBatchCount) {
        this.ecifBatchCount = ecifBatchCount;
    }

    public Integer getEcifBatchSuccessNum() {
        return ecifBatchSuccessNum;
    }

    public void setEcifBatchSuccessNum(Integer ecifBatchSuccessNum) {
        this.ecifBatchSuccessNum = ecifBatchSuccessNum;
    }

    public Integer getEcifBatchErrorNum() {
        return ecifBatchErrorNum;
    }

    public void setEcifBatchErrorNum(Integer ecifBatchErrorNum) {
        this.ecifBatchErrorNum = ecifBatchErrorNum;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "CunstomerEcifBatch{" +
                "ecifBatchId='" + ecifBatchId + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", ecifBatchCount=" + ecifBatchCount +
                ", ecifBatchSuccessNum=" + ecifBatchSuccessNum +
                ", ecifBatchErrorNum=" + ecifBatchErrorNum +
                ", isDel=" + isDel +
                ", createdTime=" + createdTime +
                ", createdUser=" + createdUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                '}';
    }
}
