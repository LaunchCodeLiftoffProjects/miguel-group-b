package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.TypeOfRestaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeOfRestaurantRepository extends CrudRepository<TypeOfRestaurant,Integer> {
}
