package com.paymentchain.customer.infraestucture.controller;

import com.paymentchain.customer.application.dto.ClientDto;
import com.paymentchain.customer.application.dto.product.ProductDto;
import com.paymentchain.customer.application.dto.transaction.TransactionDto;
import com.paymentchain.customer.application.handler.ClientHandler;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientHandler clientHandler;

    //@ApiOperation
    @ApiResponse(code = 200, message = "OK")
    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAll(){
        return new ResponseEntity<>(clientHandler.getAll(), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id){
        return new ResponseEntity<>(clientHandler.getClient(id), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PostMapping()
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientHandler.save(clientDto), HttpStatus.CREATED);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable long id, @RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientHandler.update(id, clientDto), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "No_Content"),
            @ApiResponse(code = 400, message = "Not_Found"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        clientHandler.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
/*
    @GetMapping("/products/{clientId}")
    public ResponseEntity<List<ProductDto>> getProducts (@PathVariable long clientId){
        ClientDto clientDto = clientHandler.getClient(clientId);
        if(clientDto == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(clientHandler.getProducts(clientId), HttpStatus.OK);

    }

    @GetMapping("/transactions/{clientId}")
    public ResponseEntity<List<TransactionDto>> getTransactions (@PathVariable long clientId){
        ClientDto clientDto = clientHandler.getClient(clientId);
        if(clientDto == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(clientHandler.getTransactions(clientId), HttpStatus.OK);
    }*/

    @PostMapping("/transactions/{clientId}")
    public ResponseEntity<TransactionDto> saveTransaction (@PathVariable long clientId, @RequestBody TransactionDto transactionDto){
        if(clientHandler.getClient(clientId) == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(clientHandler.saveTransaction(transactionDto, clientId), HttpStatus.OK);
    }

    @PostMapping("/products/{idClient}")
    public ResponseEntity<ProductDto> saveProduct(@PathVariable long idClient, @RequestBody ProductDto productDto){
        if(clientHandler.getClient(idClient) == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(clientHandler.saveProduct(productDto, idClient), HttpStatus.OK);
    }

    @GetMapping("productsAll/{idClient}")
    public ResponseEntity<Map<String, Object>> getAllProducts(@PathVariable long idClient){
        return new ResponseEntity<>(clientHandler.getClientProducts(idClient), HttpStatus.OK);
    }

    @GetMapping("transactionsAll/{id}")
    public ResponseEntity<Map<String, Object>> getAllTransactions(@PathVariable long id){
        return new ResponseEntity<>(clientHandler.getClientTransaction(id), HttpStatus.OK);
    }

}
