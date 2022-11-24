package com.paymentchain.transaction.infraestructure.persistence.crud;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.domain.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionCrudRepository extends CrudRepository<Transaction, Long> {

    Transaction findByIbanAccount(String ibanAccount);

    List<Transaction> findByIdClient(long idClient);
}
