package com.example.mywallet.mywalletdemo.model;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @NotBlank(message = "mandatory field, should not be empty")
    private String customerFName;
    @NotBlank(message = "mandatory field, should not be empty")
    private String customerLName;
    //@Email(message = "should be proper email address")
    private String customerMail;
    //@Size(min=10,max=10,message = "should be of length 10")
    private int customerNum;
    //
    private String password;
    private Date customerDOB;
    @NotBlank(message = "mandatory field, should not be empty")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name="id")
    @Fetch(FetchMode.JOIN)
    private MyBalance myBalance;

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



