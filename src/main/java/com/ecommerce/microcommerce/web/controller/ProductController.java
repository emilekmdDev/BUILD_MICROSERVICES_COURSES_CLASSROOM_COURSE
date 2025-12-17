package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Product> ajouterProduit(@RequestBody Product product){
        Product productAdded = productDao.save(product);
        if (Objects.isNull(productAdded)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
