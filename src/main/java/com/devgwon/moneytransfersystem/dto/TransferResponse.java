package com.devgwon.moneytransfersystem.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class TransferResponse {

    private Long transferTransactionId;

    private boolean status;

    private String fromAccountNumber;

    private String toAccountNumber;

    private String senderName;

    private String receiverName;

    private Long amount;

    private Long balance;

    //private Long fee;

    private String memo;

    private OffsetDateTime transferredAt;

}
