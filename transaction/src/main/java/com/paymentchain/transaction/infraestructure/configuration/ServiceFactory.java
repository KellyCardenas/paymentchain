package com.paymentchain.transaction.infraestructure.configuration;

import com.paymentchain.transaction.domain.repository.ITransactionRepository;
import com.paymentchain.transaction.domain.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactory {

    @Bean
    public TransactionService transactionService(ITransactionRepository transactionRepository){
        return new TransactionService(transactionRepository);
    }
}
