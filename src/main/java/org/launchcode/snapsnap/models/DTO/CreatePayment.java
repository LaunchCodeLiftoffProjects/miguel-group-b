package org.launchcode.snapsnap.models.DTO;

import com.sun.istack.NotNull;
import org.launchcode.snapsnap.models.Cart;

public class CreatePayment {

    @NotNull
    private Cart cart;

    @NotNull
    private Double amount;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getAmount() {
        return this.cart.getTotalCost().longValue();
    }

    public void setAmount(Double amount) {
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