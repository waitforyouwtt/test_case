package com.example.demo.csv;

import lombok.Data;
import lombok.ToString;


/**
 * @Author: luoxian
 * @Date: 2020/4/28 15:35
 * @Email: 15290810931@163.com
 */
@Data
@ToString
public class AliGlobalPayBillRowModel {

    //外部交易流水编码
    //@CsvBindByName(column = "Partner_transaction_id")
    private String partnerTransactionId;

    //交易流水
    //@CsvBindByName(column = "Transaction_id")
    private String transactionId;

    //@CsvBindByName(column = "Amount")
    private String amount;

    //@CsvBindByName(column = "Rmb_amount")
    private String rmbAmount;

    //@CsvBindByName(column = "Fee")
    private String fee;

    //@CsvBindByName(column = "Distribute_amount")
    private String distributeAmount;

    //@CsvBindByName(column = "Distribute_rmb_amount")
    private String distributeRmbAmount;

    //@CsvBindByName(column = "Settlement")
    private String settlement;

    //@CsvBindByName(column = "Rmb_settlement")
    private String rmbSettlement;

    //@CsvBindByName(column = "Currency")
    private String currency;

    //@CsvBindByName(column = "Rate")
    private String rate;

    //@CsvBindByName(column = "Payment_time")
    private String paymentTime;

    //@CsvBindByName(column = "Settlement_time")
    private String settlementTime;

    //@CsvBindByName(column = "Type")
    private String type;

    //@CsvBindByName(column = "Status")
    private String status;

    //@CsvBindByName(column = "Remarks")
    private String remarks;

    //@CsvBindByName(column = "code")
    private String originalPartnerTransactionId;

    //@CsvBindByName(column = "Original_partner_transaction_ID")
   // private String shroffAccountIdentity; //收款账户标识



}
