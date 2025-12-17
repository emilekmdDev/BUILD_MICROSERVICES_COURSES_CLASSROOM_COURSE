package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    public static List<Product> products = new ArrayList<>();
    static{
        products.add(new Product(1,"macbook pro m1 pro",895,700));
        products.add(new Product(2,"case m1 16inch",60, 39));
        products.add(new Product(3,"Bible",40, 39));
    }

    @Override
    public List<Product> findAll(){
        return products;
    }

    @Override
    public Product fingById(int id) {
        for (Product product : products){
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
