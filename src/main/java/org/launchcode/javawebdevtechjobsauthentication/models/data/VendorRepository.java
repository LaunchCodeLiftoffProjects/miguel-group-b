package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.Vendor;
import org.launchcode.javawebdevtechjobsauthentication.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface VendorRepository extends CrudRepository<Vendor, Integer> {
}

