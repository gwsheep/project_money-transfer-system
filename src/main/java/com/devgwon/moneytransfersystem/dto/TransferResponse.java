package com.devgwon.moneytransfersystem.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class TransferResponse {

    private Long id;

    private String status;

    private String fromAccount;

    private String toAccount;

    private String sender;

    private String receiver;

    private Long amount;

    private Long balance;

    //private Long fee;

    private String memo;

    private OffsetDateTime transferredAt;

    private boolean isSuccess;

}
