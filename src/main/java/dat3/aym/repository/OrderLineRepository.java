package dat3.aym.repository;

import dat3.aym.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository <OrderLine, Integer>{
}
