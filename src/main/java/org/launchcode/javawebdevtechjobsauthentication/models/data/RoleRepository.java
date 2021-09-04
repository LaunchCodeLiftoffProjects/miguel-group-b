package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.users.Role;
import org.launchcode.javawebdevtechjobsauthentication.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RoleRepository extends JpaRepository<Role, Integer> {

//    @Query("SELECT r FROM Roles r WHERE r.name = :name")
//    public User getRoleByRoleName(@Param("name") String name);
}
