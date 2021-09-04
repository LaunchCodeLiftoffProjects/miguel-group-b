package org.launchcode.javawebdevtechjobsauthentication;

import org.junit.jupiter.api.Test;
import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaWebDevTechjobsAuthenticationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

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

	@Test
	public void testGetCartByUser(){
		User user = new User();
		user.setId(1);
	}
}
