package com.devgwon.moneytransfersystem.dto;

import com.devgwon.moneytransfersystem.entity.Account;
import com.devgwon.moneytransfersystem.entity.TransactionStatus;
import lombok.Data;

import java.time.OffsetDateTime;

//임시
@Data
public class TransferDetailResponse {

    private Long transferTransactionId;

    private Account fromAccount;

    private Account toAccount;

    private Long amount;

    private String memo;

    private TransactionStatus status;

    private OffsetDateTime requestedAt;

    private OffsetDateTime completedAt;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
