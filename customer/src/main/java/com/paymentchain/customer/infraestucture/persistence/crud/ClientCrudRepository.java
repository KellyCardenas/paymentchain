package com.paymentchain.customer.infraestucture.persistence.crud;

import com.paymentchain.customer.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Long> {

    Client findByCode(String code);
}
