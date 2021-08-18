package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.LocationOfRestaurant;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LocationOfRestaurantRepository extends CrudRepository<LocationOfRestaurant, Integer> {
}
