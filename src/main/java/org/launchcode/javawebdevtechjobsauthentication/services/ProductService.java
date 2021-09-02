package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.exceptions.NotFoundException;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){ this.productRepository = productRepository; }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> viewAllProducts(){
        return productRepository.findAll();
    }

    public Product editProduct(Product product){ return productRepository.save(product); }
//
//    public Product findProductById(int id){
//        return productRepository.findProductById(id).orElseThrow(() -> new NotFoundException("Product with id " + id + "was not found."));
//    }

    public void deleteProduct(int id){
        productRepository.deleteProductById(id);
    }


}
