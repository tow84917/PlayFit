package com.java016.playfit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "order_record")
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    private String merchantTradeNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar paymentDate;

    private int paymentTypeChargeFee;

    private int tradeAmt;


    private String paymentType;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar tradeDate;

    private String tradeNo;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getMerchantTradeNo() {
        return merchantTradeNo;
    }

    public void setMerchantTradeNo(String merchantTradeNo) {
        this.merchantTradeNo = merchantTradeNo;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentTypeChargeFee() {
        return paymentTypeChargeFee;
    }

    public void setPaymentTypeChargeFee(int paymentTypeChargeFee) {
        this.paymentTypeChargeFee = paymentTypeChargeFee;
    }

    public int getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(int tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Calendar getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Calendar tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderRecord{");
        sb.append("id=").append(id);
        sb.append(", merchantTradeNo='").append(merchantTradeNo).append('\'');
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentTypeChargeFee=").append(paymentTypeChargeFee);
        sb.append(", tradeAmt=").append(tradeAmt);
        sb.append(", paymentType='").append(paymentType).append('\'');
        sb.append(", tradeDate=").append(tradeDate);
        sb.append(", tradeNo='").append(tradeNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
