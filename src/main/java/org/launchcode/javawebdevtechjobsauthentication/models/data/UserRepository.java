package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.users.ApplicationUser;
//import org.launchcode.javawebdevtechjobsauthentication.users.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {

//    @Query("SELECT u FROM USER u WHERE u.username = :username")

    @Query("select u from User u where u.username = :username")
    public ApplicationUser getUserByUsername(@Param("username") String username);

}
