package com.devgwon.moneytransfersystem.controller;

import com.devgwon.moneytransfersystem.dto.*;
import com.devgwon.moneytransfersystem.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class TransferController {

    private final TransferService transferService;

    @GetMapping("/transfer")
    public ResponseEntity<Response> getTransfer(@Valid TransferDetailRequest request) {
        TransferResponse transfer = transferService.getTransfer(request);
        return ResponseEntity.ok(Response.builder().result(transfer).build());
    }

    @GetMapping("/transfers")
    public ResponseEntity<Response> getTransfers() {
        TransferListResponse transferList = transferService.getTransfers();
        return ResponseEntity.ok(Response.builder().result(transferList).build());
    }

    @PostMapping("/transfer")
    public ResponseEntity<Response> transferMoney(@Valid @RequestBody TransferRequest request) {
        boolean isSuccess = transferService.transfer();
        TransferResponse res = TransferResponse.builder()
                                                .status(isSuccess)
                                                .build();
        return ResponseEntity.ok(Response.builder().result(res).build());
    }

}
