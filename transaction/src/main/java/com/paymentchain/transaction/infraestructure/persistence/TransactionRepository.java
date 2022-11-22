package com.paymentchain.transaction.infraestructure.persistence;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.domain.entity.Transaction;
import com.paymentchain.transaction.domain.repository.ITransactionRepository;
import com.paymentchain.transaction.infraestructure.mapping.TransactionMapper;
import com.paymentchain.transaction.infraestructure.persistence.crud.TransactionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository implements ITransactionRepository {

    @Autowired
    private TransactionCrudRepository transactionCrudRepository;

    @Autowired
    TransactionMapper transactionMapper;

    @Override
    public TransactionDto save(TransactionDto transactionDto){
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        return transactionMapper.toTransactionDto(transactionCrudRepository.save(transaction));
    }

    @Override
    public TransactionDto getTransaction(long id){
        TransactionDto transactionDto = transactionMapper
                .toTransactionDto(transactionCrudRepository.findById(id).get());
        return transactionDto;
    }

    @Override
    public TransactionDto getByIbanAccount(String ibanAccount){
        TransactionDto transactionDto = transactionMapper
                .toTransactionDto(transactionCrudRepository.findByIbanAccount(ibanAccount));
        return transactionDto;
    }

    @Override
    public List<TransactionDto> getAll(){
        List<TransactionDto> transactionDtos = transactionMapper
                .transactionsDto((List<Transaction>) transactionCrudRepository.findAll());
        return transactionDtos;
    }

    @Override
    public void delete(long id){
        transactionCrudRepository.deleteById(id);
    }

    @Override
    public TransactionDto getByIdClient(long idClient){
        return transactionMapper.toTransactionDto(transactionCrudRepository.findByIdClient(idClient));
    }

}
