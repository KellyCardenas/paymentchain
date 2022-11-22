package com.paymentchain.product.domain.service;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.domain.repository.IProductRepository;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
public class ProductService {

    private IProductRepository iProductRepository;

    public ProductDto save(ProductDto productDto){
        return iProductRepository.save(productDto);
    }

    public ProductDto getProduct(long id){
        return iProductRepository.getProduct(id);
    }

    public List<ProductDto> getAll(){
        return iProductRepository.getAll();
    }

    public void delete(long id){
        iProductRepository.delete(id);
    }

    public ProductDto update(ProductDto productDtoNewInfo, long id){

        ProductDto productDto = iProductRepository.getProduct(id);

        productDto.setCode(productDtoNewInfo.getCode());
        productDto.setName(productDtoNewInfo.getName());
        return iProductRepository.save(productDto);
    }

    public List<ProductDto> getByIdClient(long idClient){
        return iProductRepository.getByIdClient(idClient);
    }
}
