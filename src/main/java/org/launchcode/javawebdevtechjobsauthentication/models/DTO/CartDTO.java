package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

import java.util.List;

public class CartDTO {
    private List<CartItemDTO> cartItems;
    private double orderTotal;

    public CartDTO(List<CartItemDTO> cartItems, double orderTotal) {
        this.cartItems = cartItems;
        this.orderTotal = orderTotal;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
