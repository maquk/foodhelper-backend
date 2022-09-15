package foodhelper.backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MealDTO {
    private Long id;
    private LocalDate date;
    private List<ProductConsumedDTO> productConsumeds;
    private List<String> mealNames;
}
