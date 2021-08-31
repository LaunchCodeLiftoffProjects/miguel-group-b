package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;

public class CartItemDTO {
    private int cartId;
    private int userId;
    private int quantity;
    private Product product;

    public CartItemDTO() {}

    public CartItemDTO(Cart cart){
        this.setCartId(cart.getId());
        this.setUserId(cart.getUser().getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
