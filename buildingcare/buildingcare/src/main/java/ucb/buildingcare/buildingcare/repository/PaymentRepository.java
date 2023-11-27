package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ucb.buildingcare.buildingcare.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    @Query(value = "SELECT * FROM payment ORDER BY date DESC",
     nativeQuery = true)
    public List<Payment> findAll();
}
