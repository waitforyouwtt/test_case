package com.example.demo.entity;

import java.math.BigDecimal;

/**
 * @author jiajinxiang
 * @create 2018-04-04 18:33
 */
public class ThirdpartyBillResponseDto extends BillBaseResponse {
    private static final long serialVersionUID = -8579843719016437400L;

    private String id;                // 主键  可能是订单号 可能是退款单号
    private String billDate;        // 对账单日期  yyyy-MM-dd
    private int payMode;            // 支付方式1 威富通  2 微信  3  支付宝

    private String payTime;            // 支付时间
    private String tradeId;            // 支付中心订单号
    private String outTradeId;        // 第三方订单号
    private String refundId;        // 支付中心退款单号
    private String outRefundId;        // 第三方退款单号

    private String shopCode;        // 门店编码

    private BigDecimal payFee;        // 支付金额
    private BigDecimal refundFee;    // 退款金额
    private BigDecimal serviceFee;    // 手续费

    private String tradeStatus;        // 交易状态
    private String refundStatus;    // 退款状态

    private int result;                // 核对结果  0 不一致  1  一致     默认一致
    private String shroffAccountIdentity;        // 收款账户标识

    /**
     * 应结金额
     */
    private BigDecimal settlementTotalFee;

    /**
     * 优惠金额
     */
    private BigDecimal couponFee;

    /**
     * 退款应结金额
     */
    private BigDecimal settlementRefundFee;

    /**
     * 退款优惠金额
     */
    private BigDecimal refundCouponFee;


    private String unmatchReason; // 不一致原因

    public String getId() {
        return id;
    }

    public ThirdpartyBillResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getBillDate() {
        return billDate;
    }

    public ThirdpartyBillResponseDto setBillDate(String billDate) {
        this.billDate = billDate;
        return this;
    }

    public int getPayMode() {
        return payMode;
    }

    public ThirdpartyBillResponseDto setPayMode(int payMode) {
        this.payMode = payMode;
        return this;
    }

    public String getPayTime() {
        return payTime;
    }

    public ThirdpartyBillResponseDto setPayTime(String payTime) {
        this.payTime = payTime;
        return this;
    }

    public String getTradeId() {
        return tradeId;
    }

    public ThirdpartyBillResponseDto setTradeId(String tradeId) {
        this.tradeId = tradeId;
        return this;
    }

    public String getOutTradeId() {
        return outTradeId;
    }

    public ThirdpartyBillResponseDto setOutTradeId(String outTradeId) {
        this.outTradeId = outTradeId;
        return this;
    }

    public String getRefundId() {
        return refundId;
    }

    public ThirdpartyBillResponseDto setRefundId(String refundId) {
        this.refundId = refundId;
        return this;
    }

    public String getOutRefundId() {
        return outRefundId;
    }

    public ThirdpartyBillResponseDto setOutRefundId(String outRefundId) {
        this.outRefundId = outRefundId;
        return this;
    }

    public String getShopCode() {
        return shopCode;
    }

    public ThirdpartyBillResponseDto setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public ThirdpartyBillResponseDto setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
        return this;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public ThirdpartyBillResponseDto setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
        return this;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public ThirdpartyBillResponseDto setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public ThirdpartyBillResponseDto setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
        return this;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public ThirdpartyBillResponseDto setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public int getResult() {
        return result;
    }

    public ThirdpartyBillResponseDto setResult(int result) {
        this.result = result;
        return this;
    }

    public String getShroffAccountIdentity() {
        return shroffAccountIdentity;
    }

    public ThirdpartyBillResponseDto setShroffAccountIdentity(String shroffAccountIdentity) {
        this.shroffAccountIdentity = shroffAccountIdentity;
        return this;
    }

    public BigDecimal getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public ThirdpartyBillResponseDto setSettlementTotalFee(BigDecimal settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
        return this;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public ThirdpartyBillResponseDto setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
        return this;
    }

    public BigDecimal getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public ThirdpartyBillResponseDto setSettlementRefundFee(BigDecimal settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
        return this;
    }

    public BigDecimal getRefundCouponFee() {
        return refundCouponFee;
    }

    public ThirdpartyBillResponseDto setRefundCouponFee(BigDecimal refundCouponFee) {
        this.refundCouponFee = refundCouponFee;
        return this;
    }

    public String getUnmatchReason() {
        return unmatchReason;
    }

    public ThirdpartyBillResponseDto setUnmatchReason(String unmatchReason) {
        this.unmatchReason = unmatchReason;
        return this;
    }

    @Override
    public String toString() {
        return "ThirdpartyBillResponseDto{" +
                "id='" + id + '\'' +
                ", billDate='" + billDate + '\'' +
                ", payMode=" + payMode +
                ", payTime='" + payTime + '\'' +
                ", tradeId='" + tradeId + '\'' +
                ", outTradeId='" + outTradeId + '\'' +
                ", refundId='" + refundId + '\'' +
                ", outRefundId='" + outRefundId + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", payFee=" + payFee +
                ", refundFee=" + refundFee +
                ", serviceFee=" + serviceFee +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", result=" + result + '\'' +
                ", shroffAccountIdentity='" + shroffAccountIdentity + '\'' +
                ", settlementTotalFee=" + settlementTotalFee +
                ", couponFee=" + couponFee +
                ", settlementRefundFee=" + settlementRefundFee +
                ", refundCouponFee=" + refundCouponFee +
                ", unmatchReason='" + unmatchReason +
                "} " + super.toString();
    }
}
