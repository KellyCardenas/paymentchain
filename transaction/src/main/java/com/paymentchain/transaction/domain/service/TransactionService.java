package com.paymentchain.transaction.domain.service;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.domain.repository.ITransactionRepository;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
public class TransactionService {

    private ITransactionRepository transactionRepository;

    public TransactionDto save(TransactionDto transactionDto){
        return transactionRepository.save(transactionDto);
    }

    public TransactionDto getTransaction (long id){
        return transactionRepository.getTransaction(id);
    }

    public TransactionDto getByIbanAccount (String ibanAccount){
        return transactionRepository.getByIbanAccount(ibanAccount);
    }

    public List<TransactionDto> getAll(){
        return transactionRepository.getAll();
    }

    public void delete(long id){
        transactionRepository.delete(id);
    }

    public TransactionDto update(TransactionDto transactionDtoNewInfo, long id){

        TransactionDto transactionDto = transactionRepository.getTransaction(id);

        transactionDto.setAmount(transactionDtoNewInfo.getAmount());
        transactionDto.setDate(transactionDtoNewInfo.getDate());
        transactionDto.setChannel(transactionDtoNewInfo.getChannel());
        transactionDto.setFee(transactionDtoNewInfo.getFee());
        transactionDto.setDescription(transactionDtoNewInfo.getDescription());
        transactionDto.setStatus(transactionDtoNewInfo.getStatus());
        transactionDto.setReference(transactionDtoNewInfo.getReference());
        transactionDto.setIbanAccount(transactionDtoNewInfo.getIbanAccount());

        return transactionRepository.save(transactionDto);
    }

    public List<TransactionDto> getByIdClient(long idClient){
        return transactionRepository.getByIdClient(idClient);
    }
}
