package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.vendors.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface MenuRepository extends
        JpaRepository<Menu, Integer> {

}
