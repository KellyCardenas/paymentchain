package com.paymentchain.product.application.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
//mirar esta dep
@ApiModel("Product")
public class ProductDto implements Serializable {

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Code cannot be null")
    private String code;

    @NotBlank(message = "id client cannot be null")
    private Long idClient;
}
