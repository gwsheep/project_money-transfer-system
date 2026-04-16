package com.devgwon.moneytransfersystem.service;

import com.devgwon.moneytransfersystem.dto.*;
import com.devgwon.moneytransfersystem.entity.TransferTransaction;
import com.devgwon.moneytransfersystem.exception.TransferException;
import com.devgwon.moneytransfersystem.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransferService {

    private final TransferRepository transferRepository;

    public TransferResponse getTransfer(TransferDetailRequest request) {

        TransferTransaction transaction = transferRepository.findById(request.getId())
                .orElseThrow(() -> new TransferException(request.getId()));

        return TransferResponse.builder()
                            .id(transaction.getTransferTransactionId())
                            .status(transaction.getStatus().name())
                            .fromAccount(transaction.getFromAccount().getAccountNumber())
                            .toAccount(transaction.getToAccount().getAccountNumber())
                            .amount(transaction.getAmount())
                            .memo(transaction.getMemo())
                            .transferredAt(transaction.getCompletedAt())
                            .build();

    }

    public TransferListResponse getTransfers(TransferListRequest request) {

        //searching
        //List<TransferTransaction> transactionList = getTransactionList(request);
        int pageSize = (request.getLimit() == null) ? 20 : request.getLimit();
        Pageable pageable = PageRequest.of(0, pageSize);
        boolean hasCursorId = (request.getCursorId() != null);
        boolean hasCursorTime = (request.getCursorTime() != null);
        List<TransferTransaction> transactionList = getTransactionList(request, pageable, hasCursorId, hasCursorTime);

        //parsing
        //parseTransactionList();
        boolean hasNext = (transactionList.size() > pageSize);
        List<TransferDetailResponse> parsedList = getParsedTransactionList(transactionList, hasNext, pageSize);

        //paging
        //pagingTransactionList();
        TransferDetailResponse lastTransaction = getLastTransaction(parsedList);
        return TransferListResponse.builder()
                                .transfers(parsedList)
                                .cursorId(lastTransaction.getTransferTransactionId())
                                .cursorTime(lastTransaction.getCreatedAt())
                                //.hasNextCursor()
                                .build();

    }

    private List<TransferDetailResponse> getParsedTransactionList(List<TransferTransaction> transactionList, boolean hasNext, int pageSize) {
        List<TransferTransaction> tmpList = (hasNext) ? transactionList.subList(0, pageSize-1) : transactionList;
//        return tmpList.stream().map(e -> {
//            //변환 로직
//        }).toList();
        return null;
    }

    private TransferDetailResponse getLastTransaction(List<TransferDetailResponse> parsedList) {
        return parsedList.get(parsedList.size()-1);
    }

    private List<TransferTransaction> getTransactionList(TransferListRequest request, Pageable pageable, boolean hasCursorId, boolean hasCursorTime) {
        if(hasCursorId && hasCursorTime) {
            return transferRepository.findAllWithNoOption(pageable);
        } else {
            return transferRepository.findAllWithOptions(pageable, request.getCursorId(), request.getCursorTime());
        }

    }



    @Transactional
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
