package com.devgwon.moneytransfersystem.exception;

public class TransferException extends RuntimeException{

    public TransferException(Long transactionId) {
        super("송금 이력을 찾을 수 없습니다 = " + transactionId);
    }

}
