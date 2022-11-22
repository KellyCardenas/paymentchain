package com.paymentchain.transaction.infraestructure.controller;

import com.paymentchain.transaction.application.dto.TransactionDto;
import com.paymentchain.transaction.application.handler.TransactionHandler;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionHandler transactionHandler;

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PostMapping()
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionHandler.save(transactionDto), HttpStatus.CREATED);
    }

    @ApiResponse(code = 200, message = "OK")
    @GetMapping()
    public ResponseEntity<List<TransactionDto>> getAll(){
        return new ResponseEntity<>(transactionHandler.getAll(), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Transaction not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable long id){
        return new ResponseEntity<>(transactionHandler.getTransaction(id), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDto> update(@PathVariable long id, @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionHandler.update(transactionDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        transactionHandler.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //preguntar que pasa cuando hay muchos get, se coloca el nombre
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Transaction not found")
    })
    @GetMapping("/getClient/{id}")
    public ResponseEntity<TransactionDto> getByIdClient(@PathVariable long id){
        return new ResponseEntity<>(transactionHandler.getByIdClient(id), HttpStatus.OK);
    }
}

