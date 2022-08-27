package foodhelper.backend.repository;


import foodhelper.backend.model.Water;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WaterRepository extends JpaRepository<Water, Long> {

    List<Water> findAllByDate(LocalDate date);
}
