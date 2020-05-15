package com.example.demo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/5/12 10:04
 * @Email: 15290810931@163.com
 */
@Data
public class OrderItem {

    private Long id;
    private Long version;
    private Long orderId;
    private Integer rowNum;
    private String goodsId;
    private String goodsCode;
    private String sSkuCode;
    private String vendor;
    private String goodsName;
    private String goodsBarcode;
    private String goodsSnapshotId;
    private String goodsFlag;
    private String goodsType;
    private Long categoryId;
    private String categoryCode;
    private BigDecimal qty;
    private String unit;
    private String mainImg;
    private String specProp;
    private BigDecimal listPrice;
    private BigDecimal salePrice;
    private BigDecimal returnQty;
    private BigDecimal pRefundSubAmt;
    private BigDecimal fRefundSubAmt;
    private BigDecimal pPaidSubAmt;
    private BigDecimal fPaidSubAmt;
    private BigDecimal pPaySubAmt;
    private BigDecimal fPaySubAmt;
    private BigDecimal pLpSubAmt;
    private BigDecimal pSpSubAmt;
    private BigDecimal fSubAmt;
    private BigDecimal pPromoSubAmt;
    private BigDecimal fPromoSubAmt;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private BigDecimal pPointpaySubAmt;
    private BigDecimal fPointpaySubAmt;
    private BigDecimal fBalancepaySubAmt;
    private BigDecimal pBalancepaySubAmt;
    private Long parentOrderItemId;
    private Long rootOrderItemId;
    private Integer skuDeliveryType;
    private String warehouseId;
    private Integer warehouseType;
    private Long parentBomOrderItemId;
    private BigDecimal displayPrice;
    private BigDecimal pDispSpSubAmt;
    private Integer bomType;
    private String supplierCode;
    private Integer expiration;
    private String foodItemCode;
    private BigDecimal displayQty;
    private Integer propertyType;
    private BigDecimal specQty;
    private Integer isRefund;
    private Integer foodAllowRefund;
    private String foodRefundReason;
    private String priceKind;
    private Long yhcommercial;
    private String erpShopId;
    private String shopId;
    private Integer balanceRefund;
    private BigDecimal actualWeight;
    private String bundlePromoCode;
    private String bundleItemType;
    private String spuCode;
    private BigDecimal grossWeight;
    private BigDecimal pxPromoSubAmt;
    private BigDecimal fxPromoSubAmt;
    private BigDecimal pxWxPromoSubAmt;
    private BigDecimal fxWxPromoSubAmt;
    private String orderRemark;
    private String batch;
    private String extension;
    private BigDecimal discount;
    private Integer pseudoFresh;
    private BigDecimal appointPrice;
    private BigDecimal pTaxSubAmt;
    private BigDecimal fTaxSubAmt;
    private BigDecimal taxRate;
    private Long itemBusinessFlag;
}
