package org.launchcode.javawebdevtechjobsauthentication.models.DTO;

public class AddToCartDTO {

    private int productId;
    private int quantity;

    public AddToCartDTO() { }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddToCartDTO{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
