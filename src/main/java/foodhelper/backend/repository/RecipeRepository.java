package foodhelper.backend.repository;

import foodhelper.backend.dto.NutrientDTO;
import foodhelper.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByName(String name);

    @Query(value = "SELECT recipe.id, recipe.name, recipe.preparation_time, recipe.description," +
            " recipe.recipe_difficulty FROM RECIPE JOIN recipe_products ON" +
            " recipe.id = recipe_products.recipe_id JOIN PRODUCT ON recipe_products.products_id" +
            " = product.id GROUP BY RECIPE.id" +
            " HAVING SUM(product.fat) < :fat AND" +
            " SUM(product.protein) < :protein AND" +
            " SUM(product.carbohydrates) < :carbohydrates"
            ,nativeQuery = true)
    List<Recipe> findRecipeByNutrientValues(
            @Param("fat") BigDecimal fat,
            @Param("protein") BigDecimal protein,
            @Param("carbohydrates") BigDecimal carbohydrates);

}