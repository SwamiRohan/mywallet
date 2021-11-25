package com.example.mywallet.mywalletdemo.model;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="MyBalance")
public class MyBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerBId;
    private double currBalance=0;
    private double creditBalance=0;
    private double debitBalance=0;
    @ManyToOne(targetEntity = Customer.class)
    private Set<Customer> customer;

    public int getCustomerBId() {
        return customerBId;
    }

    public void setCustomerBId(int customerBId) {
        this.customerBId = customerBId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCurrBalance() {
        return currBalance;
    }

    public void setCurrBalance(double currBalance) {
        this.currBalance = currBalance;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public double getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(double debitBalance) {
        this.debitBalance = debitBalance;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
