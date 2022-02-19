package com.example.products.services;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.products.shared.ProductDTO;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    /**
     * This method returns all the products in the database
     * @return
     */
    public List<ProductDTO> getProducts(){
        List<Product> productList = productRepo.findAll();

        return productList.stream().map(product -> new ModelMapper().map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    /**
     * This method returns a product if exists in the database
     * @param id
     * @return
     */

    public Optional<ProductDTO> getProductById(Integer id){
        Optional<Product> product = productRepo.findById(id);

        if(product.isEmpty()){
            throw new InputMismatchException("Product not found");
        }

        ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);
        return Optional.of(dto);        
    }

    /**
     * This method returns a new added product to the database
     * @param product
     * @return
     */
    public ProductDTO addProduct(ProductDTO product){
        product.setId(null); //To be generated from the JPA and hibernate
        Product productNormal = new ModelMapper().map(product, Product.class);
        productRepo.save(productNormal);
        product.setId(productNormal.getId());
        return product;
    }

    /**
     * This method deletes a product if exists by the identificator
     * @param id
     */
    public void deleteProduct(Integer id){
        Optional<Product> product = productRepo.findById(id);

        if(product.isEmpty()){
            throw new InputMismatchException("Product not found");
        }

        productRepo.deleteById(id);
    }

    /**
     * This method allows the client to uptade any products in the database by its id
     * @param product
     * @param id
     * @return
     */
    public ProductDTO uptadeProduct(ProductDTO product, Integer id){
        product.setId(id);
        Product productNormal = new ModelMapper().map(product, Product.class);
        productRepo.save(productNormal);
        return product;
    }
    
}
