package com.paymentchain.customer.infraestucture.persistence.feignClient;

import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "transaction-service", url = "http://localhost:8081")
//@RequestMapping("/transactions")
public interface TransactionFeignClient {

  @RequestMapping(value = "/transactions", method = RequestMethod.POST)
  TransactionDto save(@RequestBody TransactionDto transactionDto);
}
