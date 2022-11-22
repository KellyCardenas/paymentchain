package com.paymentchain.product.domain.repository;

import com.paymentchain.product.application.dto.ProductDto;

import java.util.List;

public interface IProductRepository {

    ProductDto save(ProductDto productDto);

    ProductDto getProduct(long id);

    List<ProductDto> getAll();

    void delete(long id);

    List<ProductDto> getByIdClient(long id);

}
