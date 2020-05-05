package com.stas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
    private long id;
    private String login;
    private String password;
    private String birthdate;
    private double value;
    private String sex;
    private String creditdate;
    private double creditvalue;
    private String depositdate;
    private double depositvalue;
    private double creditpercent;
    private String creditname;
    private double depositpercent;
    private String depositname;

    public Account() {
        creditdate = "0000-00-00";
        creditvalue = 0;
        depositdate = "0000-00-00";
        depositvalue = 0;
        creditpercent = 0;
        creditname = "No bank";
        depositname = "No bank";
        depositpercent = 0;
    }

    public Account(long id, String login, String password, String birthdate, double value, String sex, String creditdate, double creditvalue, String depositdate, double depositvalue, double creditpercent, String creditname, double depositpercent, String depositname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.value = value;
        this.sex = sex;
        this.creditdate = creditdate;
        this.creditvalue = creditvalue;
        this.depositdate = depositdate;
        this.depositvalue = depositvalue;
        this.creditpercent = creditpercent;
        this.creditname = creditname;
        this.depositpercent = depositpercent;
        this.depositname = depositname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreditdate() {
        return creditdate;
    }

    public void setCreditdate(String creditdate) {
        this.creditdate = creditdate;
    }

    public double getCreditvalue() {
        return creditvalue;
    }

    public void setCreditvalue(double creditvalue) {
        this.creditvalue = creditvalue;
    }

    public String getDepositdate() {
        return depositdate;
    }

    public void setDepositdate(String depositdate) {
        this.depositdate = depositdate;
    }

    public double getDepositvalue() {
        return depositvalue;
    }

    public void setDepositvalue(double depositvalue) {
        this.depositvalue = depositvalue;
    }

    public double getCreditpercent() {
        return creditpercent;
    }

    public void setCreditpercent(double creditpercent) {
        this.creditpercent = creditpercent;
    }

    public String getCreditname() {
        return creditname;
    }

    public void setCreditname(String creditname) {
        this.creditname = creditname;
    }

    public double getDepositpercent() {
        return depositpercent;
    }

    public void setDepositpercent(double depositpercent) {
        this.depositpercent = depositpercent;
    }

    public String getDepositname() {
        return depositname;
    }

    public void setDepositname(String depositname) {
        this.depositname = depositname;
    }
}

