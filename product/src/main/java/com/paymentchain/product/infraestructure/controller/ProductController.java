package com.paymentchain.product.infraestructure.controller;

import com.paymentchain.product.application.dto.ProductDto;
import com.paymentchain.product.application.handler.ProductHandler;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ReadPendingException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductHandler productHandler;

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PostMapping()
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productHandler.save(productDto), HttpStatus.CREATED);
    }

    @ApiResponse(code = 200, message = "OK")
    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(productHandler.getAll(), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        return new ResponseEntity<>(productHandler.getProduct(id), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto, @PathVariable long id){
        return new ResponseEntity<>(productHandler.update(productDto,id), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "No_Content"),
            @ApiResponse(code = 400, message = "Not_Found"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(long id){
        productHandler.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //preguntar que pasa cuando hay muchos get, se coloca el nombre
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/productsClient/{idClient}")
    public ResponseEntity<List<ProductDto>> getByIdClient(@PathVariable long idClient){
        List<ProductDto> productDtos = productHandler.getByIdClient(idClient);
        return ResponseEntity.ok(productDtos);
    }
}
