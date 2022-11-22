package com.paymentchain.transaction.infraestructure.mapping;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.domain.entity.Transaction;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "reference", target = "reference"),
            @Mapping(source = "ibanAccount", target = "ibanAccount"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "channel", target = "channel"),
            @Mapping(source = "idClient", target = "idClient")
    })
    TransactionDto toTransactionDto(Transaction transaction);

    List<TransactionDto> transactionsDto(List<Transaction> transactions);

    @InheritInverseConfiguration
    Transaction toTransaction(TransactionDto transactionDto);
}
