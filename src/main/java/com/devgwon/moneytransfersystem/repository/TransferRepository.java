package com.devgwon.moneytransfersystem.repository;

import com.devgwon.moneytransfersystem.entity.TransferTransaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransferRepository extends JpaRepository<TransferTransaction, Long> {

    @Query("""
            SELECT t 
            FROM TransferTransaction as t 
            ORDER BY t.createdAt desc, t.transferTransactionId desc                      
            """)
    public List<TransferTransaction> findAllWithNoOption(Pageable pageable);

    @Query("""
            SELECT t
            FROM TransferTransaction t
            WHERE 
            """)
    public List<TransferTransaction> findAllWithOptions(Pageable pageable, int cursorId, OffsetDateTime cursorTime);

}
