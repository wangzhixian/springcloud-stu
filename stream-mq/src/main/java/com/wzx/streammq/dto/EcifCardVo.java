package com.wzx.streammq.dto;

import java.io.Serializable;
import java.util.List;

public class EcifCardVo implements Serializable {
    /**
     *发送时间
     */
    private String sendDate;

    /**
     *唯一序列
     */
    private String seqNo;

    /**
     *唯一序列
     */
    private String serviceCode;

    /**
     *唯一序列
     */
    private List<CardVouchers> cardVouchersList;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
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

    public List<CardVouchers> getCardVouchersList() {
        return cardVouchersList;
    }

    public void setCardVouchersList(List<CardVouchers> cardVouchersList) {
        this.cardVouchersList = cardVouchersList;
    }

    @Override
    public String toString() {
        return "EcifCardVo{" +
                "sendDate='" + sendDate + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", cardVouchersList=" + cardVouchersList +
                '}';
    }
}
