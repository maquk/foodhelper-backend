package foodhelper.backend.dto;

import foodhelper.backend.model.Product;
import foodhelper.backend.model.RecipeDifficulty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {

    private Long id;
    private String name;
    private Integer preparationTime;
    private String description;
    private RecipeDifficulty recipeDifficulty;
    private List<ProductDTO> products;
}
