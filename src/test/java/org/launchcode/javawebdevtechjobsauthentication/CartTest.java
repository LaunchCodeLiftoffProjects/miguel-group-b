package org.launchcode.javawebdevtechjobsauthentication;

import org.junit.jupiter.api.Test;
import org.launchcode.javawebdevtechjobsauthentication.controllers.CartController;
import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CartTest {
    @Autowired
    private CartController cartController;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void addItemToCart(){
        Product product = entityManager.find(Product.class, 44);
        User user = entityManager.find(User.class, 1);
        Cart newCart = new Cart();
        newCart.setProduct(product);
        newCart.setUser(user);
        newCart.setQuantity(1);

        Cart saveCart = cartRepository.save(newCart);

        assertTrue(saveCart.getId() > 0);
    }

}
