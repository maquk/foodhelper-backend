package foodhelper.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductConsumedDTO {
    private Long id;
    private ProductDTO product;
    private BigDecimal grams;
}
