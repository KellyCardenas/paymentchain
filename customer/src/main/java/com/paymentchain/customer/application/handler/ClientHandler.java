package com.paymentchain.customer.application.handler;

import com.paymentchain.customer.application.dto.ClientDto;
import com.paymentchain.customer.application.dto.product.ProductDto;
import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import com.paymentchain.customer.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientHandler {

    @Autowired
    private ClientService clientService;

    public List<ClientDto> getAll(){
        return clientService.getAll();
    }

    public ClientDto save(ClientDto clientDto){
        return clientService.save(clientDto);
    }

    public ClientDto getClient(long id){
        return clientService.getClient(id);
    }

    public ClientDto getByCode(String code){
        return clientService.getByCode(code);
    }

    public void delete(long id){
        clientService.delete(id);
    }

    public ClientDto update(long id, ClientDto clientDtoNewInfo){
        return clientService.update(id, clientDtoNewInfo);
    }

    public void getTransaction(long id){
        clientService.getTransaction(id);
    }

    /*
    public List<ProductDto> getProducts(long clientId){
        return clientService.getProducts(clientId);
    }

    public List<TransactionDto> getTransactions(long clientId){
        return clientService.getTransactions(clientId);
    }*/

    public TransactionDto saveTransaction(TransactionDto transactionDto, long id){
        return clientService.saveTransaction(transactionDto, id);
    }

    public ProductDto saveProduct (ProductDto productDto, long idClient){
        return clientService.saveProduct(productDto, idClient);
    }

    public Map<String, Object> getClientProducts(long idClient){
        return clientService.getClientProducts(idClient);
    }
}
