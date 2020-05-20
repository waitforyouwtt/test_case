package com.example.demo.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * @Author: luoxian
 * @Date: 2020/4/28 15:35
 * @Email: 15290810931@163.com
 */
@Data
@ToString
public class AliGlobalPayBillRowModel {

    //商户交易号（即：支付时请求参数中的Out_trade_no或者退款时的out_return_no）
    private String partnerTransactionId;

    //交易金额（外币）
    private String amount;

    //	交易金额（人民币）
    private String rmbAmount;

    //手续费（外币）
    private String fee;

    //结算金额（外币）
    private String settlement;

    //结算金额（人民币）
    private String rmbSettlement;

    //币种
    private String currency;

    //	汇率
    private String rate;

    //支付时间
    private String paymentTime;

    //结算时间
    private String settlementTime;

    //交易类型
    private String type;

    //交易状态  交易已成功：P   交易已清算：L
    private String status;

    //备注
    private String remarks;

    //原始商户交易号（即：支付时上传的out_trade_no）
    private String originalPartnerTransactionId;

    public String getPartnerTransactionId() {
        return partnerTransactionId;
    }

    public void setPartnerTransactionId(String partnerTransactionId) {
        this.partnerTransactionId = partnerTransactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRmbAmount() {
        return rmbAmount;
    }

    public void setRmbAmount(String rmbAmount) {
        this.rmbAmount = rmbAmount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getRmbSettlement() {
        return rmbSettlement;
    }

    public void setRmbSettlement(String rmbSettlement) {
        this.rmbSettlement = rmbSettlement;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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
}
