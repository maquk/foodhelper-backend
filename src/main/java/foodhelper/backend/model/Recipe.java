package foodhelper.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer preparationTime;
    private String description;
    private RecipeDifficulty recipeDifficulty;

    @OneToMany
    private List<Product> products;

}
