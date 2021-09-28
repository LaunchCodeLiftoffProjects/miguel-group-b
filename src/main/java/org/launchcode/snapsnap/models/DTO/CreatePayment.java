package org.launchcode.snapsnap.models.DTO;

import javax.validation.constraints.NotNull;

public class CreatePayment {

    @NotNull
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
//
//    @SerializedName("items")
//    Object[] items;
//
//    public Object[] getItems() { return items; }
//
//    @Autowired
//    private CartService cartService;
//
//
//    public List<CartItem> getCartItems(HttpServletRequest request){
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        Cart cart = cartService.findBySessionToken(sessionToken);
//        return cart.getCartItems();
//    }