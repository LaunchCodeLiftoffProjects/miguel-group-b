package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

import java.util.List;

public class CartDTO {

    private List<CartItemDTO> cartItems;
    private Double orderTotal;

    public CartDTO(List<CartItemDTO> cartItemDTOList, Double orderTotal) {
        this.cartItems = cartItemDTOList;
        this.orderTotal = orderTotal;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItemDTOList) {
        this.cartItems = cartItemDTOList;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
