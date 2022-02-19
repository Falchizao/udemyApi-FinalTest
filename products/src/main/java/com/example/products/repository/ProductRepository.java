package com.example.products.repository;


import org.springframework.stereotype.Repository;
import com.example.products.model.Product;
import org.springframework.data.jpa.repository.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
      
}
                            