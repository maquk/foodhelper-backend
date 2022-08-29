package foodhelper.backend.controller;

import foodhelper.backend.dto.NutrientDTO;
import foodhelper.backend.dto.RecipeDTO;
import foodhelper.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDTO> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(recipeService.findByName(name));
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RecipeDTO recipeDTO) {
        recipeService.save(recipeDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RecipeDTO recipeDTO) {
        recipeService.update(recipeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findRecipeByNutrientValues(@RequestBody NutrientDTO nutrientDTO) {
        return ResponseEntity.ok(recipeService.findRecipeByNutrientValues(nutrientDTO));
    }

}
