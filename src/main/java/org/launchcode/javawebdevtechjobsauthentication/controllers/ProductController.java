package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

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

    //TODO: TEST ADD METHODS
//    @GetMapping("add/{productId}")
//    public String addItemToCart(Model model, @ModelAttribute Cart newCart){
//        model.addAttribute("products", productRepository.findAll());
//        return"add/{productId}";
//    }
//    //DOES THIS EVEN MEAN ANYTHING
//    @PostMapping("add/{productId}")
//    public String processAddItemToCart(@RequestParam int productId, @ModelAttribute Cart newCart, @ModelAttribute Product newProduct,Model model){
//        model.addAttribute("productId", productRepository.findById(newProduct.getId()));
//        newCart.addProduct(newProduct);
//
//        return"redirect:";
//    }
//    @GetMapping("add")
//    public String addItemToCart(Model model){
//        model.addAttribute("products", productRepository.findAll());
//        return "products/add";
//    }
//
//    @PostMapping("add")
//    public String processAddItemToCart(@ModelAttribute Product newProduct, @ModelAttribute Cart newCart, Model model){
//        newCart.addProduct(newProduct);
//        return "products/add";
//    }
//

//@GetMapping("view")
//public String displayProducts(@RequestParam(required = false) Integer productId, Model model) {
//
//    if (productId == null) {
//        model.addAttribute("title", "All Products");
//        model.addAttribute("products", productRepository.findAll());
//    } else {
//        Optional<Product> result = productRepository.findById(productId);
//        if (result.isEmpty()) {
//            model.addAttribute("title", "Invalid ID: " + productId);
//        } else {
//            Product product = result.get();
//            model.addAttribute("title", "Products: " + product.getName());
//            model.addAttribute("products", product.getId());
//            return "products/view/{productId}";
//            }
//        }
//        return "products/view";
//    }

//    @GetMapping("edit/{productId}")
//    public String editProductForm(Model model, @PathVariable int productId){
//        model.addAttribute("title", "Edit Product");
//        model.addAttribute("product", productRepository.findById(productId));
//        return "edit/{productId}";
//    }
//
//    @PostMapping("edit/{productId}")
//    public String processEditProductForm(@ModelAttribute Product newProduct, Model model){
//        model.addAttribute("name", newProduct.setName());
//        model.addAttribute("description", newProduct.setDescription());
//        model.addAttribute("price", newProduct.setPrice());
//        return "redirect:";
//    }

}
