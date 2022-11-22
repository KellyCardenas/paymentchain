package com.paymentchain.customer.domain.service;

import com.paymentchain.customer.application.dto.ClientDto;
import com.paymentchain.customer.application.dto.product.ProductDto;
import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import com.paymentchain.customer.domain.repository.IClientRepository;
import com.paymentchain.customer.infraestucture.persistence.feignClient.ProductFeignClient;
import com.paymentchain.customer.infraestucture.persistence.feignClient.TransactionFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Transactional
public class ClientService {

    private IClientRepository iClientRepository;

    private RestTemplate restTemplate;

    private TransactionFeignClient transactionFeignClient;

    private ProductFeignClient productFeignClient;

    public ClientDto save(ClientDto clientDto){
        return iClientRepository.save(clientDto);
    }

    public ClientDto getClient(long id){
        return iClientRepository.getClient(id);
    }

    public List<ClientDto> getAll(){
        return  iClientRepository.getAll();
    }

    public void delete(long id){
        iClientRepository.delete(id);
    }

    public void getTransaction(long idTransaction){
        iClientRepository.getTransaction(idTransaction);
    }

    public ClientDto update (long id, ClientDto clientDtoNewInfo){

        ClientDto clientDto = iClientRepository.getClient(id);
        clientDto.setAddress(clientDtoNewInfo.getAddress());
        clientDto.setCode(clientDtoNewInfo.getCode());
        clientDto.setName(clientDtoNewInfo.getName());
        clientDto.setPhone(clientDtoNewInfo.getPhone());
        clientDto.setLastName(clientDtoNewInfo.getLastName());

        return iClientRepository.save(clientDto);
    }

    public ClientDto getByCode(String code){
        return iClientRepository.getByCode(code);

    }

    /*
    public List<TransactionDto> getTransactions (long id){
        List<TransactionDto> transactions = restTemplate.getForObject("http://localhost:8081/transactions/getClient/" + id, List.class);
        return transactions;
    }

    public List<ProductDto> getProducts (long id){
        List<ProductDto> products = restTemplate.getForObject("http://localhost:8082/products/getClient/" + id, List.class);
        return products;
    }
    */

    public ProductDto saveProduct(ProductDto productDto, long idClient){
        productDto.setIdClient(idClient);
        return productFeignClient.save(productDto);
    }

    public TransactionDto saveTransaction(TransactionDto transactionDto, long id){
        transactionDto.setIdClient(id);
        return transactionFeignClient.save(transactionDto);
    }

    public Map<String, Object> getClientProducts (long idClient){

        Map<String, Object> result = new HashMap<>();
        ClientDto clientDto = iClientRepository.getClient(idClient);
        if(clientDto == null) {
            result.put("Mensaje", "Client doesn't exist");
            return result;
        }

        result.put("Client", clientDto);
        List<ProductDto> productDtos = productFeignClient.getByIdClient(idClient);
        if (productDtos.isEmpty())
            result.put("Products", "Client with out productd");
        else
            result.put("Products", productDtos);

        return result;
    }
}
