package com.viettelmor.reportvast.BusinessObject;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
@Entity
@Table(name = "CHARGE_LOG", schema = "PROGW", catalog = "")
public class ChargeLog {
    private long id;
    private String username;
    private String ip;
    private String servicesCode;
    private String msisdn;
    private String chargType;
    private String amount;
    private Date chargeTime;
    private String description;
    private String errorOcs;
    private Long duration;
    private String requestId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "SERVICES_CODE")
    public String getServicesCode() {
        return servicesCode;
    }

    public void setServicesCode(String servicesCode) {
        this.servicesCode = servicesCode;
    }

    @Basic
    @Column(name = "MSISDN")
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Basic
    @Column(name = "CHARG_TYPE")
    public String getChargType() {
        return chargType;
    }

    public void setChargType(String chargType) {
        this.chargType = chargType;
    }

    @Basic
    @Column(name = "AMOUNT")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "CHARGE_TIME")
    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ERROR_OCS")
    public String getErrorOcs() {
        return errorOcs;
    }

    public void setErrorOcs(String errorOcs) {
        this.errorOcs = errorOcs;
    }

    @Basic
    @Column(name = "DURATION")
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "REQUEST_ID")
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeLog that = (ChargeLog) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(servicesCode, that.servicesCode) &&
                Objects.equals(msisdn, that.msisdn) &&
                Objects.equals(chargType, that.chargType) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(chargeTime, that.chargeTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(errorOcs, that.errorOcs) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(requestId, that.requestId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, ip, servicesCode, msisdn, chargType, amount, chargeTime, description, errorOcs, duration, requestId);
    }
}
