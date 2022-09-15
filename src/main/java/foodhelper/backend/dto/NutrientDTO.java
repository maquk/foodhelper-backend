package foodhelper.backend.dto;

import foodhelper.backend.model.NutrientValue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NutrientDTO {
    private List<MealDTO> meals;
    private BigDecimal calories = BigDecimal.ZERO;
    private BigDecimal protein = BigDecimal.ZERO;
    private BigDecimal fat = BigDecimal.ZERO;
    private BigDecimal carbohydrates = BigDecimal.ZERO;
    private NutrientValue nutrientValue;
}
