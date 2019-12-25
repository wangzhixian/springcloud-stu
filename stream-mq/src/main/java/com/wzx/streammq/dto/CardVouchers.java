package com.wzx.streammq.dto;

import java.io.Serializable;

public class CardVouchers implements Serializable {
    /**
     *卡券临时唯一
     */
    private String cardVouchersUnique;

    /**
     *活动名称
     */
    private String activityName;

    /**
     *卡券领取截止时间
     */
    private String cardCouponDeadline;

    /**
     *费用归属单位-分类1
     */
    private String feeAffiliationUnit1;

    /**
     *费用归属单位-分类Code1
     */
    private String feeAffiliationUnit1Code;

    /**
     *费用归属单位-分类2
     */
    private String feeAffiliationUnit2;

    /**
     *费用归属单位-分类Code2
     */
    private String feeAffiliationUnit2Code;

    /**
     *费用来源分类
     */
    private String costSources;

    /**
     *卡劵id
     */
    private String pid;

    /**
     *卡劵名称
     */
    private String name;

    /**
     *标签值
     * 1：第三方验证【真】
     * 2：大数据验证【真】（分值大于1000）
     * 11：第三方验证为【假】
     * 12：第三方验证为【不可验证等】
     * 99:其他
     * 100：禁止拨打号码；
     * 101：空错号、停机等；
     */
    private String tagValue;

    /**
     *标签说明
     */
    private String tagDes;

    /**
     *活动代码
     */
    private String tid;

    /**
     *费用来源分类的代码
     * 1推销费用
     * 2客服费用
     * 3部门费用
     * 4其他费用
     */
    private String costSourcesCode;

    public String getCardVouchersUnique() {
        return cardVouchersUnique;
    }

    public void setCardVouchersUnique(String cardVouchersUnique) {
        this.cardVouchersUnique = cardVouchersUnique;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCardCouponDeadline() {
        return cardCouponDeadline;
    }

    public void setCardCouponDeadline(String cardCouponDeadline) {
        this.cardCouponDeadline = cardCouponDeadline;
    }

    public String getFeeAffiliationUnit1() {
        return feeAffiliationUnit1;
    }

    public void setFeeAffiliationUnit1(String feeAffiliationUnit1) {
        this.feeAffiliationUnit1 = feeAffiliationUnit1;
    }

    public String getFeeAffiliationUnit1Code() {
        return feeAffiliationUnit1Code;
    }

    public void setFeeAffiliationUnit1Code(String feeAffiliationUnit1Code) {
        this.feeAffiliationUnit1Code = feeAffiliationUnit1Code;
    }

    public String getFeeAffiliationUnit2() {
        return feeAffiliationUnit2;
    }

    public void setFeeAffiliationUnit2(String feeAffiliationUnit2) {
        this.feeAffiliationUnit2 = feeAffiliationUnit2;
    }

    public String getFeeAffiliationUnit2Code() {
        return feeAffiliationUnit2Code;
    }

    public void setFeeAffiliationUnit2Code(String feeAffiliationUnit2Code) {
        this.feeAffiliationUnit2Code = feeAffiliationUnit2Code;
    }

    public String getCostSources() {
        return costSources;
    }

    public void setCostSources(String costSources) {
        this.costSources = costSources;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public String getTagDes() {
        return tagDes;
    }

    public void setTagDes(String tagDes) {
        this.tagDes = tagDes;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCostSourcesCode() {
        return costSourcesCode;
    }

    public void setCostSourcesCode(String costSourcesCode) {
        this.costSourcesCode = costSourcesCode;
    }

    @Override
    public String toString() {
        return "CardVouchers{" +
                "cardVouchersUnique='" + cardVouchersUnique + '\'' +
                ", activityName='" + activityName + '\'' +
                ", cardCouponDeadline='" + cardCouponDeadline + '\'' +
                ", feeAffiliationUnit1='" + feeAffiliationUnit1 + '\'' +
                ", feeAffiliationUnit1Code='" + feeAffiliationUnit1Code + '\'' +
                ", feeAffiliationUnit2='" + feeAffiliationUnit2 + '\'' +
                ", feeAffiliationUnit2Code='" + feeAffiliationUnit2Code + '\'' +
                ", costSources='" + costSources + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", tagValue='" + tagValue + '\'' +
                ", tagDes='" + tagDes + '\'' +
                ", tid='" + tid + '\'' +
                ", costSourcesCode='" + costSourcesCode + '\'' +
                '}';
    }
}
