package foodhelper.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NutrientDTO {
    private BigDecimal calories = BigDecimal.ZERO;
    private BigDecimal protein = BigDecimal.ZERO;
    private BigDecimal fat = BigDecimal.ZERO;
    private BigDecimal carbohydrates = BigDecimal.ZERO;
}
