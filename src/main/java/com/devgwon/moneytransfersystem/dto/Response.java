package com.devgwon.moneytransfersystem.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

    private Long errorCode;

    private String message;

    private Object result;

    //ex : transactionId, ...

}
