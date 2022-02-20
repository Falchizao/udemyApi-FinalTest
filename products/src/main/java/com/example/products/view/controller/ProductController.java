package com.example.products.view.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.products.services.ProductService;
import com.example.products.shared.ProductDTO;
import com.example.products.view.model.ProductResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProduct(){
        List<ProductDTO> products = productService.getProducts();        
        return new ResponseEntity<>(products.stream().map(productDTO -> new ModelMapper().map(productDTO, ProductResponse.class)).collect(Collectors.toList()), HttpStatus.OK); 
        
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> getProductById(@PathVariable Integer id){
        Optional<ProductDTO> dto = productService.getProductById(id);

        ProductResponse products = new ModelMapper().map(dto, ProductResponse.class);

        return new ResponseEntity<>(Optional.of(products) , HttpStatus.OK); //Status 200
    }
    
}
