package com.paymentchain.customer.infraestucture.configuration;

import com.paymentchain.customer.domain.repository.IClientRepository;
import com.paymentchain.customer.domain.service.ClientService;
import com.paymentchain.customer.infraestucture.persistence.feignClient.ProductFeignClient;
import com.paymentchain.customer.infraestucture.persistence.feignClient.TransactionFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceFactory {

    @Bean
    public ClientService clientService(IClientRepository clientRepository, RestTemplate restTemplate,
                                       TransactionFeignClient transactionFeignClient, ProductFeignClient productFeignClient){
        return new ClientService(clientRepository, restTemplate, transactionFeignClient, productFeignClient);
    }

}
