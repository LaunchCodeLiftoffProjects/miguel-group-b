package org.launchcode.snapsnap.models.data;

import org.launchcode.snapsnap.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    public Cart findBySessionToken(String sessionToken);
}
