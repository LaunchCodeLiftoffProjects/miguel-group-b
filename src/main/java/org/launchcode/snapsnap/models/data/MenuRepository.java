package org.launchcode.snapsnap.models.data;

import org.launchcode.snapsnap.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
