package foodhelper.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToMany
    private List<ProductConsumed> productConsumeds;

    @ElementCollection
    private List<String> mealNames;
}
