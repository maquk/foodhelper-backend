package foodhelper.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    private BigDecimal grams;
    private BigDecimal calories;
    private BigDecimal carbohydrates;
    private BigDecimal fat;
    private BigDecimal protein;
}
