package com.devgwon.moneytransfersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferListResponse {

    List<TransferDetailResponse> response;

    Long cursor;

    Boolean hasNextCursor;

}
