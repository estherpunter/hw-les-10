package nl.novi.huiswerkopdrachtles10.repository;

import nl.novi.huiswerkopdrachtles10.televisions.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
