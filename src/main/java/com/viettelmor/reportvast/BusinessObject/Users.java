package com.viettelmor.reportvast.BusinessObject;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "USERS", schema = "PROGW", catalog = "")
public class Users {
    private int userId;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private Time pwdChangedTime;
    private Time dateCreated;
    private Time dateLogged;
    private Time dateChangedPassword;

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FULLNAME")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "PWD_CHANGED_TIME")
    public Time getPwdChangedTime() {
        return pwdChangedTime;
    }

    public void setPwdChangedTime(Time pwdChangedTime) {
        this.pwdChangedTime = pwdChangedTime;
    }

    @Basic
    @Column(name = "DATE_CREATED")
    public Time getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Time dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "DATE_LOGGED")
    public Time getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Time dateLogged) {
        this.dateLogged = dateLogged;
    }

    @Basic
    @Column(name = "DATE_CHANGED_PASSWORD")
    public Time getDateChangedPassword() {
        return dateChangedPassword;
    }

    public void setDateChangedPassword(Time dateChangedPassword) {
        this.dateChangedPassword = dateChangedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullname, that.fullname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(pwdChangedTime, that.pwdChangedTime) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(dateLogged, that.dateLogged) &&
                Objects.equals(dateChangedPassword, that.dateChangedPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, password, fullname, email, phone, pwdChangedTime, dateCreated, dateLogged, dateChangedPassword);
    }
}
