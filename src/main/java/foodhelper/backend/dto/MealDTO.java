package foodhelper.backend.dto;

import foodhelper.backend.model.Product;
import foodhelper.backend.model.ProductConsumed;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
public class MealDTO {
    private Long id;
    private LocalDate date;
    private List<ProductConsumedDTO> productConsumeds;
}
