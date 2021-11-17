package com.example.mywallet.mywalletdemo.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    //@Email
    private String customerMail;
    //@Size(min=10,max=10,message = "should be of length 10")
    private int customerNum;
    //@NotBlank(message = "mandatory field, should not be empty")
    private String customerAddress;

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



