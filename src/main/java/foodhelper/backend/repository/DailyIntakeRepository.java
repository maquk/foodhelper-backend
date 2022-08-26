package foodhelper.backend.repository;

import foodhelper.backend.model.DailyIntake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyIntakeRepository extends JpaRepository<DailyIntake, Long> {


}
