package com.paymentchain.transaction.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Data
@Table(name = "transactions")
public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    @Column(name = "iban_account")
    private String ibanAccount;

    private LocalDate date;

    private Double amount;

    private Double fee;

    private String description;

    private String status;

    private String channel;

    @Column(name = "id_client")
    private Long idClient;
}
