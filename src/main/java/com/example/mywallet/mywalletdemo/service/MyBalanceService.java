package com.example.mywallet.mywalletdemo.service;

import com.example.mywallet.mywalletdemo.model.MyBalance;
import com.example.mywallet.mywalletdemo.repository.CustomerRepository;
import com.example.mywallet.mywalletdemo.repository.MyBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyBalanceService {
    @Autowired
    MyBalanceRepository myBalanceRepository;
    @Autowired
    CustomerRepository customerRepository;

    public MyBalance creditMyWallet(MyBalance myBalance){
        myBalance.setCustomerBId(myBalance.getCustomerBId());
        myBalance.setCreditBalance(myBalance.getCreditBalance());
        myBalance.setCurrBalance(myBalance.getCurrBalance()+ myBalance.getCreditBalance());
        return myBalanceRepository.save(myBalance);
    }


    public MyBalance debitMyWalletById(MyBalance myBalance){
        myBalance.setCustomerBId(myBalance.getCustomerBId());
        myBalance.setDebitBalance(myBalance.getDebitBalance());
        myBalance.setCurrBalance(myBalance.getCurrBalance() - myBalance.getDebitBalance());
        return myBalanceRepository.save(myBalance);
    }

    public List<MyBalance> getBalanceOfAllUser(){
        List<MyBalance> balances = new ArrayList<>();
        myBalanceRepository.findAll().forEach(balances1 -> balances.add(balances1));
        return balances;
    }

}
