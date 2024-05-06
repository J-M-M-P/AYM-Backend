package dat3.aym.repository;

import dat3.aym.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository <Material, Integer> {
}
