package org.launchcode.javawebdevtechjobspersistent;

import org.junit.jupiter.api.Test;
import org.launchcode.javawebdevtechjobsauthentication.controllers.CartController;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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
    private TestEntityManager entityManager;

    @Test
    public void shouldAddOneProductToCart(){
        entityManager.find(Product.class, primaryKey)
    }
//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(cartController).isNotNull();
//    }

//    @Test
//    public void shouldAddProductToCart() throws Exception{
//    }
}
