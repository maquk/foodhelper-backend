package foodhelper.backend.service;

import foodhelper.backend.dto.NutrientDTO;
import foodhelper.backend.dto.RecipeDTO;
import foodhelper.backend.exception.EntityNotFoundException;
import foodhelper.backend.model.Recipe;
import foodhelper.backend.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
    }

    public List<RecipeDTO> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDTO.class)).collect(Collectors.toList());

    }

    public RecipeDTO findByName(String name) {
        Recipe recipe = recipeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with name " + name + " not found"));

        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public RecipeDTO findById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with id " + id + " not found"));
        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public void save(RecipeDTO recipeDTO) {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        recipeRepository.save(recipe);
    }

    public void update(RecipeDTO recipeDTO) {
        recipeRepository.save(modelMapper.map(recipeDTO, Recipe.class));

    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<RecipeDTO> findRecipeUpToCalories(NutrientDTO nutrientDTO){
        List<Recipe> recipes = recipeRepository.findRecipeUpToCalories(nutrientDTO.getCalories());
        
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDTO.class)).collect(Collectors.toList());

    }

}
