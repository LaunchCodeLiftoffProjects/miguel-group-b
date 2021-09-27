package org.launchcode.snapsnap.models.DTO;

import com.google.gson.annotations.SerializedName;
import org.launchcode.snapsnap.models.Cart;
import org.launchcode.snapsnap.models.CartItem;
import org.launchcode.snapsnap.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreatePayment {

    @SerializedName("items")
    Object[] items;

    public Object[] getItems() { return items; }

    @Autowired
    private CartService cartService;

    public List<CartItem> getCartItems(HttpServletRequest request){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        Cart cart = cartService.findBySessionToken(sessionToken);
        return cart.getCartItems();
    }

}
