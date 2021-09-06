package org.launchcode.javawebdevtechjobsauthentication.models.data;




import org.launchcode.javawebdevtechjobsauthentication.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RestaurantRepository extends
        CrudRepository<Restaurant,Integer> {
}

