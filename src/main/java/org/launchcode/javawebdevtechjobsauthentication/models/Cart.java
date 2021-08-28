package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart extends AbstractEntity {

    @OneToMany(mappedBy = "cart")
    private List<Product> cartItems = new ArrayList<>();

    public Cart(){}

    public Cart(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Product> getCartItems() { return cartItems; }

    public void setCartItems(List<Product> cartItems) {this.cartItems = cartItems; }

    public Double getCartTotal(List<Product> cartItems){
        double sum = 0;
        for(int i = 0; i < cartItems.size();i++){
            sum += cartItems.get(i).getPrice();
        }
        return sum;
    }

    //TODO: TEST METHODS
    public List<Product> addProduct(Product product){
        this.cartItems.add(product);
        return cartItems;
    }

    public List<Product> removeProduct(int productId){
        this.cartItems.remove(productId);
        return cartItems;
    }

    public List<Product> addToCartById(Product[] products){
        for(Product p : products){
            cartItems.get(p.getId());
        }
        return cartItems;
    }

}
