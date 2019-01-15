package com.viettelmor.reportvast.ViewModel;

import com.viettelmor.reportvast.BusinessObject.ChargeLog;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class DataTable implements Serializable {
    private String msisdn;
    private String chargType;
    private String amount;
    private Date chargeTime;
    private String description;
    private String errorOcs;
    private String requestId;

    public DataTable(ChargeLog chargeLog) {
        msisdn = chargeLog.getMsisdn();
        chargType = chargeLog.getChargType();
        amount = chargeLog.getAmount();
        chargeTime = chargeLog.getChargeTime();
        description = chargeLog.getDescription();
        errorOcs = chargeLog.getErrorOcs();
        requestId = chargeLog.getRequestId();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getChargType() {
        return chargType;
    }

    public void setChargType(String chargType) {
        this.chargType = chargType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getChargeTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(chargeTime);
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorOcs() {
        return errorOcs;
    }

    public void setErrorOcs(String errorOcs) {
        this.errorOcs = errorOcs;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "{" +
                "msisdn:'" + msisdn + '\'' +
                ", chargType:'" + chargType + '\'' +
                ", amount:'" + amount + '\'' +
                ", chargeTime:" + chargeTime +
                ", description:'" + description + '\'' +
                ", errorOcs:'" + errorOcs + '\'' +
                ", requestId:'" + requestId + '\'' +
                '}';
    }
}
