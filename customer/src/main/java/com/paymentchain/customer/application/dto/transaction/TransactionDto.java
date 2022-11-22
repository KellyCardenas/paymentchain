package com.paymentchain.customer.application.dto.transaction;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class TransactionDto {

    @NotBlank(message = "reference cannot be null")
    private String reference;

    @NotBlank(message = "IbanAccount cannot be null")
    private String ibanAccount;

    @NotBlank(message = "Date cannot be null")
    private LocalDate date;

    @NotBlank(message = "Amount cannot be null")
    private Double amount;

    @NotBlank(message = "Fee cannot be null")
    private Double fee;

    @NotBlank(message = "Description cannot be null")
    private String description;

    @NotBlank(message = "Status cannot be null")
    private String status;

    @NotBlank(message = "Channel cannot be null")
    private String channel;

    @NotBlank(message = "Id client cannot be null")
    private Long idClient;

}
