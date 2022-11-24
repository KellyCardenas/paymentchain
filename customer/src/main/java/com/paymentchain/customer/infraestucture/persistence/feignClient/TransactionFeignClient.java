package com.paymentchain.customer.infraestucture.persistence.feignClient;

import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "transaction")
public interface TransactionFeignClient {

  @RequestMapping(value = "/transactions", method = RequestMethod.POST)
  TransactionDto save(@RequestBody TransactionDto transactionDto);

  @RequestMapping(value = "/transactions/transactionsClient/{id}", method = RequestMethod.GET)
  List<TransactionDto> getByIdClient (@PathVariable long id);
}
