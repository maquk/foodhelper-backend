package foodhelper.backend.repository;

import foodhelper.backend.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeightRepository extends JpaRepository<Weight, Long> {

    List<Weight> findAllByDateBetween(LocalDate fromDate, LocalDate toDate);
}
