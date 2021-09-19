package org.launchcode.snapsnap.models.data;

import org.launchcode.snapsnap.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
