package com.cjp.shopcart.shoppingcartservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjp.shopcart.shoppingcartservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}