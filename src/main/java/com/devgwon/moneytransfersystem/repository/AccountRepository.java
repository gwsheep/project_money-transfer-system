package com.devgwon.moneytransfersystem.repository;

import com.devgwon.moneytransfersystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
