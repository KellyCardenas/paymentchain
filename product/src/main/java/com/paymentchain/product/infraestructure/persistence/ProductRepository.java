package com.paymentchain.product.infraestructure.persistence;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.domain.entity.Product;
import com.paymentchain.product.domain.repository.IProductRepository;
import com.paymentchain.product.infraestructure.mapping.ProductMapper;
import com.paymentchain.product.infraestructure.persistence.crud.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    //no podria retornar el mismo prodcut que entra?
    @Override
    public ProductDto save(ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        Product productS = productCrudRepository.save(product);
        return productMapper.toProductDto(productS);
    }

    @Override
    public ProductDto getProduct(long id){
        Product product = productCrudRepository.findById(id).get();
        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProductsDto(products);
    }

    @Override
    public void delete(long id){
        productCrudRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getByIdClient(long idClient){
        List<Product> products = productCrudRepository.findByIdClient(idClient);
        return productMapper.toProductsDto(products);
    }
}
