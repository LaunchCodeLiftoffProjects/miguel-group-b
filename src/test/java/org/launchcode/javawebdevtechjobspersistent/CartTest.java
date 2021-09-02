package org.launchcode.javawebdevtechjobspersistent;

import org.junit.jupiter.api.Test;
import org.launchcode.javawebdevtechjobsauthentication.controllers.CartController;
import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@Rollback(false)
public class CartTest {

    @Autowired
    private CartController cartController;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldAddOneProductToCart(){

        Cart newCart = new Cart();
    }
//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(cartController).isNotNull();
//    }

//    @Test
//    public void shouldAddProductToCart() throws Exception{
//    }
}
