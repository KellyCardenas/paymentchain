package com.paymentchain.product.infraestructure.configuration;

import com.paymentchain.product.domain.repository.IProductRepository;
import com.paymentchain.product.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactory {

    @Bean
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }
}
