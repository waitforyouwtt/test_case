package com.example.demo.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/4/28 15:35
 * @Email: 15290810931@163.com
 */
@Data
public class AliGlobalPayBillRowModel {

    //外部交易流水编码
    @CsvBindByName(column = "Partner_transaction_id")
    private String partnerTransactionId;

    //交易流水
    @CsvBindByName(column = "Transaction_id")
    private String transactionId;

    @CsvBindByName(column = "Amount")
    private BigDecimal amount;

    @CsvBindByName(column = "Rmb_amount")
    private BigDecimal rmbAmount;

    @CsvBindByName(column = "Fee")
    private BigDecimal fee;

    @CsvBindByName(column = "Distribute_amount")
    private BigDecimal distributeAmount;

    @CsvBindByName(column = "Distribute_rmb_amount")
    private BigDecimal distributeRmbAmount;

    @CsvBindByName(column = "Settlement")
    private String settlement;

    @CsvBindByName(column = "Rmb_settlement")
    private BigDecimal rmbSettlement;

    @CsvBindByName(column = "Currency")
    private String currency;

    @CsvBindByName(column = "Rate")
    private Double rate;

    @CsvBindByName(column = "Payment_time")
    private String paymentTime;

    @CsvBindByName(column = "Settlement_time")
    private String settlementTime;

    @CsvBindByName(column = "Type")
    private String type;

    @CsvBindByName(column = "Status")
    private String status;

    @CsvBindByName(column = "Remarks")
    private String remarks;

    @CsvBindByName(column = "code")
    private String originalPartnerTransactionId;

    @CsvBindByName(column = "Original_partner_transaction_ID")
    private String shroffAccountIdentity; //收款账户标识

    public String getPartnerTransactionId() {
        return partnerTransactionId;
    }

    public void setPartnerTransactionId(String partnerTransactionId) {
        this.partnerTransactionId = partnerTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRmbAmount() {
        return rmbAmount;
    }

    public void setRmbAmount(BigDecimal rmbAmount) {
        this.rmbAmount = rmbAmount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getDistributeAmount() {
        return distributeAmount;
    }

    public void setDistributeAmount(BigDecimal distributeAmount) {
        this.distributeAmount = distributeAmount;
    }

    public BigDecimal getDistributeRmbAmount() {
        return distributeRmbAmount;
    }

    public void setDistributeRmbAmount(BigDecimal distributeRmbAmount) {
        this.distributeRmbAmount = distributeRmbAmount;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public BigDecimal getRmbSettlement() {
        return rmbSettlement;
    }

    public void setRmbSettlement(BigDecimal rmbSettlement) {
        this.rmbSettlement = rmbSettlement;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOriginalPartnerTransactionId() {
        return originalPartnerTransactionId;
    }

    public void setOriginalPartnerTransactionId(String originalPartnerTransactionId) {
        this.originalPartnerTransactionId = originalPartnerTransactionId;
    }

    public String getShroffAccountIdentity() {
        return shroffAccountIdentity;
    }

    public void setShroffAccountIdentity(String shroffAccountIdentity) {
        this.shroffAccountIdentity = shroffAccountIdentity;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }
}
