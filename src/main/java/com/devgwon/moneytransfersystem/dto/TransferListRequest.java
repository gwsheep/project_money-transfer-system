package com.devgwon.moneytransfersystem.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TransferListRequest {

    //검색 옵션


    //Paging
    private OffsetDateTime cursorTime;
    private Integer cursorId;
    private Integer limit;

}
