package org.launchcode.snapsnap.models.data;

import org.launchcode.snapsnap.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
