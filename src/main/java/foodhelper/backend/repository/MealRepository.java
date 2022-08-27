package foodhelper.backend.repository;

import foodhelper.backend.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findAllByDate(LocalDate date);
}
