package foodhelper.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String producer;
    private BigDecimal grams;
    private BigDecimal calories;
    private BigDecimal carbohydrates;
    private BigDecimal fat;
    private BigDecimal protein;
}
