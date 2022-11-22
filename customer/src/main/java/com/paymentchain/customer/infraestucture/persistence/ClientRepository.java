package com.paymentchain.customer.infraestucture.persistence;

import com.paymentchain.customer.application.dto.ClientDto;
import com.paymentchain.customer.domain.entity.Client;
import com.paymentchain.customer.domain.repository.IClientRepository;
import com.paymentchain.customer.infraestucture.mapping.ClientMapper;
import com.paymentchain.customer.infraestucture.persistence.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClientRepository implements IClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public ClientDto save(ClientDto clientDto){
        Client client = clientMapper.toClient(clientDto);
        Client client1 = clientCrudRepository.save(client);
        return clientMapper.toClientDto(client1);
    }

    @Override
    public List<ClientDto> getAll(){
        List<Client> clients = (List<Client>) clientCrudRepository.findAll();
        return clientMapper.toClientsDto(clients);
    }

    @Override
    public ClientDto getByCode(String code){
        Client client = clientCrudRepository.findByCode(code);
        return clientMapper.toClientDto(client);
    }

    @Override
    public ClientDto getClient(long id){

        Client client = clientCrudRepository.findById(id).get();
        ClientDto clientDto = clientMapper.toClientDto(client);
        return clientDto;
    }

    @Override
    public void delete(Long id){
        clientCrudRepository.deleteById(id);
    }

    @Override
    public void getTransaction(long idTransaction) {

    }
}
