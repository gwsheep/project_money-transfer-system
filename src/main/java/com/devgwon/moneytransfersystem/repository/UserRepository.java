package com.devgwon.moneytransfersystem.repository;

import com.devgwon.moneytransfersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
