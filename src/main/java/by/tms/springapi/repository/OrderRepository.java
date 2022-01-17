package by.tms.springapi.repository;

import by.tms.springapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    boolean existsByPetIdOrId(Long petId,Long id);
}
