package org.launchcode.snapsnap.services;

import org.launchcode.snapsnap.models.CartItem;
import org.launchcode.snapsnap.models.Product;
import org.launchcode.snapsnap.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Integer productId){
       return productRepository.getProductById(productId);
    }
}
