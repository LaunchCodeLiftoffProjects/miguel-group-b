package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "Products");
        model.addAttribute("products", productRepository.findAll());
        return "products/index";
    }

    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Product());
        return "products/add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute Product newProduct, Errors errors){
        if(errors.hasErrors()){
            return "products/add";
        }
        productRepository.save(newProduct);
        return "redirect:";
    }

    @GetMapping("view/{productId}")
    public String viewProductById(Model model, @PathVariable int productId){
        Optional optItem = productRepository.findById(productId);
        if(optItem.isPresent()){
            Product product = (Product) optItem.get();
            model.addAttribute("product", product);
            return "products/view";
        } else {
            return "redirect:";
        }
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


@GetMapping("view")
public String displayProducts(@RequestParam(required = false) Integer productId, Model model) {

    if (productId == null) {
        model.addAttribute("title", "All Products");
        model.addAttribute("products", productRepository.findAll());
    } else {
        Optional<Product> result = productRepository.findById(productId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid ID: " + productId);
        } else {
            Product product = result.get();
            model.addAttribute("title", "Products: " + product.getName());
            model.addAttribute("products", product.getId());
            return "products/view/{productId}";
            }
        }
        return "products/view";
    }

}
