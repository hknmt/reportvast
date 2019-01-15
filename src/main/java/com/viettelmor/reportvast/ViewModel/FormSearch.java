package com.viettelmor.reportvast.ViewModel;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class FormSearch {
    @NotNull
    @Size(max = 50)
    private String serviceCode;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date from;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date to;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
