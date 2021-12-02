package com.example.mywallet.mywalletdemo.repository;

import com.example.mywallet.mywalletdemo.dto.CustomerWalletDTO;
import com.example.mywallet.mywalletdemo.model.MyBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MyBalanceRepository extends JpaRepository<MyBalance,Integer> {

}
