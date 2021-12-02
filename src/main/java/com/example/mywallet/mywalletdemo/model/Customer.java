package com.example.mywallet.mywalletdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    //@NotBlank(message = "mandatory field, should not be empty")
    private String customerFName;
    //@NotBlank(message = "mandatory field, should not be empty")
    private String customerLName;
    //@Email(message = "should be proper email address")
    private String customerMail;
    //@Size(min=10,max=10,message = "should be of length 10")
    private int customerNum;
    //
    private String password;
    private Date customerDOB;
    //@NotBlank(message = "mandatory field, should not be empty")
    private String customerAddress;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customerBId")
    private MyBalance myBalance;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BalanceHistory> balanceHistories = new ArrayList<>();


    public List<BalanceHistory> getBalanceHistory() {
        return balanceHistories;
    }

    public void setBalanceHistory(List<BalanceHistory> balanceHistories) {
        this.balanceHistories = balanceHistories;
    }

    public Customer(){

    }

    public Customer(int customerId, String customerFName, String customerLName, String customerMail, List<BalanceHistory> balanceHistories) {
        this.customerId = customerId;
        this.customerFName = customerFName;
        this.customerLName = customerLName;
        this.customerMail = customerMail;
        this.balanceHistories = balanceHistories;
    }

    public MyBalance getMyBalance() {
        return myBalance;
    }

    public void setMyBalance(MyBalance myBalance) {
        this.myBalance = myBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(Date customerDOB) {
        this.customerDOB = customerDOB;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerLName() {
        return customerLName;
    }

    public void setCustomerLName(String customerLName) {
        this.customerLName = customerLName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}



