package com.practice.crud.azure.service;

import com.practice.crud.azure.entity.Product;
import com.practice.crud.azure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
       return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Successfully deleted : "+id;
    }

    public Product updateProduct(Product product) {

        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (null == existingProduct) {
            return null;
        }
        existingProduct.setName(existingProduct.getName());
        existingProduct.setPrice(existingProduct.getPrice());
        existingProduct.setQuantity(existingProduct.getQuantity());
        return productRepository.save(existingProduct);
    }

}
