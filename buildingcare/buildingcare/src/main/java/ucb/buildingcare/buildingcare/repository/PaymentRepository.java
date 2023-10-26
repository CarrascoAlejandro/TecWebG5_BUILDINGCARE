package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.buildingcare.buildingcare.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
}
