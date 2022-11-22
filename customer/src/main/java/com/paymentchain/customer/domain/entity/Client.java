package com.paymentchain.customer.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clientes")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @Column(name="last_name")
    private String lastName;

    private String phone;

    private String address;

    @Transient
    private List<?> transactions;


}
