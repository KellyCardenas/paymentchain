package com.paymentchain.transaction.domain.repository;

import com.paymentchain.transaction.application.dto.TransactionDto;

import java.util.List;

public interface ITransactionRepository {

    TransactionDto save(TransactionDto transactionDto);

    TransactionDto getByIbanAccount(String ibanAccount);

    TransactionDto getTransaction(long id);

    List<TransactionDto> getAll();

    void delete(long id);

    TransactionDto getByIdClient(long idClient);
}
