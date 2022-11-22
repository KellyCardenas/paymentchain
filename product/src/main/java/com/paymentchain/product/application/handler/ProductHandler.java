package com.paymentchain.product.application.handler;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.domain.entity.Product;
import com.paymentchain.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHandler {

    @Autowired
    private ProductService productService;

    public ProductDto save (ProductDto productDto){
        return productService.save(productDto);
    }

    public ProductDto getProduct (long id){
        return productService.getProduct(id);
    }

    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    public void delete(long id){
        productService.delete(id);
    }

    public ProductDto update(ProductDto productDto, long id){
        return productService.update(productDto, id);
    }

    public List<ProductDto> getByIdClient(long idClient){
        return productService.getByIdClient(idClient);
    }

}
