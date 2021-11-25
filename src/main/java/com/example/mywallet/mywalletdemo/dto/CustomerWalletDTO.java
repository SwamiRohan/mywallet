package com.example.mywallet.mywalletdemo.dto;

public class CustomerWalletDTO {
    private int customerId;
    private String customerName;
    private double walletCurrBalance;
    private double walletCreditBalance;
    private double walletDebitBalance;

    public CustomerWalletDTO(int customerId, String customerName, double walletCurrBalance,
                             double walletCreditBalance, double walletDebitBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.walletCurrBalance = walletCurrBalance;
        this.walletCreditBalance = walletCreditBalance;
        this.walletDebitBalance = walletDebitBalance;
    }

    @Override
    public String toString() {
        return "CustomerWalletDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", walletCurrBalance=" + walletCurrBalance +
                ", walletCreditBalance=" + walletCreditBalance +
                ", walletDebitBalance=" + walletDebitBalance +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getWalletCurrBalance() {
        return walletCurrBalance;
    }

    public void setWalletCurrBalance(double walletCurrBalance) {
        this.walletCurrBalance = walletCurrBalance;
    }

    public double getWalletCreditBalance() {
        return walletCreditBalance;
    }

    public void setWalletCreditBalance(double walletCreditBalance) {
        this.walletCreditBalance = walletCreditBalance;
    }

    public double getWalletDebitBalance() {
        return walletDebitBalance;
    }

    public void setWalletDebitBalance(double walletDebitBalance) {
        this.walletDebitBalance = walletDebitBalance;
    }
}
