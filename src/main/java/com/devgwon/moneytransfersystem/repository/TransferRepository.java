package com.devgwon.moneytransfersystem.repository;

import com.devgwon.moneytransfersystem.entity.TransferTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferTransaction, Long> {
}
