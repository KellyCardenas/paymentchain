package com.paymentchain.transaction.application.handler;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.domain.entity.Transaction;
import com.paymentchain.transaction.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHandler {

    @Autowired
    private TransactionService transactionService;

    public TransactionDto save(TransactionDto transactionDto){
        return transactionService.save(transactionDto);
    }

    public TransactionDto getTransaction(long id){
        return transactionService.getTransaction(id);
    }

    public TransactionDto getByIbanAccount(String ibanAccount){
        return transactionService.getByIbanAccount(ibanAccount);
    }

    public List<TransactionDto> getAll(){
        return transactionService.getAll();
    }

    public TransactionDto update(TransactionDto transactionDto, long id){
        return transactionService.update(transactionDto, id);
    }

    public void delete(long id){
        transactionService.delete(id);
    }

    public TransactionDto getByIdClient (long id){
       return transactionService.getByIdClient(id);
    }
}
