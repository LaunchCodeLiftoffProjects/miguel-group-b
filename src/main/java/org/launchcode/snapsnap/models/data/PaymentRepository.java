package org.launchcode.snapsnap.models.data;

import org.launchcode.snapsnap.models.UserPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PaymentRepository extends CrudRepository<UserPayment, Double> {
}
