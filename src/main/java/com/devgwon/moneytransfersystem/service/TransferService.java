package com.devgwon.moneytransfersystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransferService {






    //@Transactional
    public boolean transfer() {

        // 송금자 계좌 조회, 검증
        boolean isRemitterValid = isRemitterValid();

        // 수취인 계좌 조회, 검증
        boolean isBeneficiaryValid = isBeneficiaryValid();

        // 검증되었다면, 송금자 잔액 차감
        withdraw();

        // 수취인 잔액 증가
        deposit();

        // 거래 상태 : 성공 (or 실패) - 기존 상태와 비교 필요한지?

        return true;

    }

    private boolean isRemitterValid() {

        return true;
    }

    private boolean isBeneficiaryValid() {

        return true;
    }

    private void withdraw() {

    }

    private void deposit() {

    }






}
