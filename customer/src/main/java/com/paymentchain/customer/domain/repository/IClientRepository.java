package com.paymentchain.customer.domain.repository;

import com.paymentchain.customer.application.dto.ClientDto;

import java.util.List;

public interface IClientRepository {

    ClientDto save(ClientDto clientDto);
    List<ClientDto> getAll();
    ClientDto getByCode(String code);
    ClientDto getClient(long id);
    void delete(Long id);
    void getTransaction(long idTransaction );

}
