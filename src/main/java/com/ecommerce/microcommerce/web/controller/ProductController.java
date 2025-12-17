package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public final ProductDaoImpl productDao = new ProductDaoImpl();

    @GetMapping("/Produits")
    public List<Product> listeProduits(){
        return  productDao.findAll();
    }

    @GetMapping("/Produits/{id}")
    public Product afficherUnProduits(@PathVariable int id){
        return productDao.fingById(id);
    }

    @PostMapping("/Produits")
    public Product save(@RequestBody Product product){
        productDao.save(product);
        return product;
    }
}
