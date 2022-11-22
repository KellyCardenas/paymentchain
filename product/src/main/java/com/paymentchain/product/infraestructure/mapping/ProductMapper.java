package com.paymentchain.product.infraestructure.mapping;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.domain.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "Spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "idClient", target = "idClient")
    })
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductsDto(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct (ProductDto productDto);
}
