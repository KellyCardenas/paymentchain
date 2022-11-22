package com.paymentchain.customer.infraestucture.persistence.feignClient;

import com.paymentchain.customer.application.dto.product.ProductDto;
import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductFeignClient {

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    ProductDto save(@RequestBody ProductDto productDto);

    @RequestMapping(value = "/products/productsClient/{idClient}", method = RequestMethod.GET)
    List<ProductDto> getByIdClient (@PathVariable long idClient);
}
