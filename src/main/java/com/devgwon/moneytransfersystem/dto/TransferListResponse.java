package com.devgwon.moneytransfersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferListResponse {

    private List<TransferDetailResponse> transfers;

    private Long cursorId;

    private OffsetDateTime cursorTime;

    private Boolean hasNextCursor;

}
