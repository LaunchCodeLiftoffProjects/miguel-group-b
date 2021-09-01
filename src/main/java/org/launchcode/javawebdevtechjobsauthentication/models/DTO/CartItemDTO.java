package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;

import javax.validation.constraints.NotNull;

public class CartItemDTO {

    private int userId;

    @NotNull
    private Product product;
    @NotNull
    private int quantity;

    public CartItemDTO() {}

    public CartItemDTO(Cart cart) {
        this.setUserId(cart.getUser().getId());
        this.setProduct(cart.getProduct());
        this.setQuantity(cart.getQuantity());
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "userId=" + userId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
