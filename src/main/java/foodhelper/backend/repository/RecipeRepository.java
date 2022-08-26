package foodhelper.backend.repository;

import foodhelper.backend.dto.RecipeDTO;
import foodhelper.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByName(String name);

    @Query("SELECT recipe.id, SUM(product.calories) FROM RECIPE JOIN recipe_products ON" +
            " recipe.id = recipe_products.recipe_id JOIN PRODUCT ON recipe_products.products_id" +
            " = product.id GROUP BY RECIPE.id HAVING SUM(product.calories) < :calories")
    List<Recipe> findRecipeUpToCalories(BigDecimal calories);
}