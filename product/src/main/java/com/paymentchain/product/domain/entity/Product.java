package com.paymentchain.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @Column(name = "id_client")
    private Long idClient;
}
