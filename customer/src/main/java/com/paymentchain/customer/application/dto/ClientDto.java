package com.paymentchain.customer.application.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel("Client User")
public class ClientDto implements Serializable {

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Code cannot be null")
    private String code;

    @NotBlank(message = "Last name cannot be null")
    private String lastName;

    @NotBlank(message = "Phone cannot be null")
    private String phone;

    @NotBlank(message = "Address cannot be null")
    private String address;
}
