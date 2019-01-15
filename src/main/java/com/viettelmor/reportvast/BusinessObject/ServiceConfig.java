package com.viettelmor.reportvast.BusinessObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SERVICE_CONFIG", schema = "PROGW", catalog = "")
public class ServiceConfig {
    private String username;
    private String serviceCode;
    private String maxValue;
    private String defaultValue;
    private String note;

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "SERVICE_CODE")
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Basic
    @Column(name = "MAX_VALUE")
    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    @Basic
    @Column(name = "DEFAULT_VALUE")
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceConfig that = (ServiceConfig) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(serviceCode, that.serviceCode) &&
                Objects.equals(maxValue, that.maxValue) &&
                Objects.equals(defaultValue, that.defaultValue) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, serviceCode, maxValue, defaultValue, note);
    }
}
