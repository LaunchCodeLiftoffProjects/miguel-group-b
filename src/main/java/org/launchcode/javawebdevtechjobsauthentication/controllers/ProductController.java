package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartServices;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/all")
//    public ResponseEntity<List<Product>> viewAllProducts(Model model){
//        List<Product> products = productService.viewAllProducts();
//        model.addAttribute("products", productService.viewAllProducts());
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("/view/{id}")
//    public ResponseEntity<Product> viewProductById(@PathVariable("id") int id, Model model){
//        Product product = productService.findProductById(id);
//        model.addAttribute("product", product);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
////    @GetMapping("/add")
////    public String addProduct(Model model){
////        model.addAttribute(new Product());
////        return "products/add";
////    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Product> processAddProduct(@RequestBody Product product){
//        Product newProduct = productService.addProduct(product);
//        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/edit")
//    public ResponseEntity<Product> editProduct(@RequestBody Product product){
//        Product editProduct = productService.editProduct(product);
//        return new ResponseEntity<>(editProduct, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
//        productService.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartServices cartServices;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "Products Home");
        model.addAttribute("products", productRepository.findAll());
        return "products/index";
    }

    @GetMapping("add")
    public String addProduct(Model model){
        model.addAttribute("title", "Add Item");
        model.addAttribute(new Product());
        return "products/add";
    }

    @PostMapping("add")
    public String processAddProduct(@ModelAttribute @Valid Product newProduct, Errors errors, Model model){
        if(errors.hasErrors()){
            return "products/add";
        }
        productRepository.save(newProduct);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteProduct(Model model){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("products", productRepository.findAll());
        return "products/delete";
    }

    @PostMapping("delete")
    public String processDeleteProduct(@RequestParam(required = false) int[] productIds) {
        if (productIds != null) {
            for(int id : productIds) {
                productRepository.deleteById(id);
            }
        }
    return "redirect:";
    }

    @GetMapping("view/{productId}")
    public String viewProductById(Model model, @PathVariable int productId){
        Optional optItem = productRepository.findById(productId);;
        if(optItem.isPresent()){
            Product product = (Product) optItem.get();
            model.addAttribute("product", product);
            return "products/view";
        } else {
            return "redirect:";
        }
    }

}
