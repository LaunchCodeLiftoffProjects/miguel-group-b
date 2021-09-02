package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;

import javax.validation.constraints.NotNull;

public class CartProductDTO {

    @NotNull
    private Cart cart;

    @NotNull
    private Product product;

    public CartProductDTO(){}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
