package foodhelper.backend.service;

import foodhelper.backend.repository.DailyIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyIntakeService {
    private final DailyIntakeRepository dailyIntakeRepository;

    @Autowired
    public DailyIntakeService(DailyIntakeRepository dailyIntakeRepository) {
        this.dailyIntakeRepository = dailyIntakeRepository;
    }

    public
}
