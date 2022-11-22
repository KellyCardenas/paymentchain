package com.paymentchain.customer.application.dto.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDto {

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Code cannot be null")
    private String code;

    @NotBlank(message = "Id client cannot be null")
    private Long idClient;

}
