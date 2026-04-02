package com.devgwon.moneytransfersystem.controller;

import com.devgwon.moneytransfersystem.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/money")
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<?> transferMoney() {

        //요청 유효성 검증

        //transfer - Account
        boolean isTransferSuccess = transferService.transfer();

        return ResponseEntity.ok("test");

    }


}
