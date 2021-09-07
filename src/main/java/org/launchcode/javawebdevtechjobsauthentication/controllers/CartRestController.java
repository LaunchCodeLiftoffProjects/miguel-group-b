package org.launchcode.javawebdevtechjobsauthentication.controllers;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.services.CartServices;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartRestController {

    @Autowired
    private CartServices cartServices;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> viewProducts(Model model){
        List<Product> products = new ArrayList<>();
        products = productService.viewAllProducts();
        model.addAttribute("products", productService.viewAllProducts());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/cart/add/{productId}/{quantity}")
    public String addProductToCart(@PathVariable int productId, @PathVariable int quantity){
        int addedQuantity = cartServices.addProductQuantity(productId, quantity);
        return addedQuantity + " item(s) added to cart.";
    }

}
