package com.paymentchain.product.infraestructure.persistence.crud;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    List<Product> findByIdClient (long idClient);
}
