package foodhelper.backend.service;

import foodhelper.backend.dto.MealDTO;
import foodhelper.backend.dto.NutrientDTO;
import foodhelper.backend.model.Meal;
import foodhelper.backend.model.Product;
import foodhelper.backend.model.ProductConsumed;
import foodhelper.backend.repository.MealRepository;
import foodhelper.backend.repository.ProductConsumedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;

    private final ProductConsumedRepository productConsumedRepository;

    private final ProductService productService;

    private final ModelMapper modelMapper;

    @Autowired
    public MealService(MealRepository mealRepository, ProductConsumedRepository productConsumedRepository,
                       ProductService productService, ModelMapper modelMapper) {
        this.mealRepository = mealRepository;
        this.productConsumedRepository = productConsumedRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public void save(MealDTO mealDTO) {
        Meal meal = modelMapper.map(mealDTO, Meal.class);
        if(meal.getDate() == null) meal.setDate(LocalDate.now());
        for (ProductConsumed productConsumed : meal.getProductConsumeds()) {
            productConsumed.setProduct(modelMapper
                    .map(productService.findById(productConsumed.getProduct().getId()), Product.class));
        }
        productConsumedRepository.saveAll(meal.getProductConsumeds());
        mealRepository.save(meal);
    }

    public void update(MealDTO mealDTO) {
        mealRepository.save(modelMapper.map(mealDTO, Meal.class));
    }

    public NutrientDTO findAllByDate(LocalDate date) {
        NutrientDTO nutrientDTO = new NutrientDTO();

        List<Meal> meals = mealRepository.findAllByDate(date);

        for (Meal meal : meals) {
            BigDecimal calories = BigDecimal.ZERO;
            BigDecimal proteins = BigDecimal.ZERO;
            BigDecimal fats = BigDecimal.ZERO;
            BigDecimal carbohydrates = BigDecimal.ZERO;
            for (ProductConsumed productConsumed : meal.getProductConsumeds()) {
                calories = calories.add(productConsumed.getProduct().getCalories()
                        .multiply(productConsumed.getGrams().divide(productConsumed.getProduct().getGrams())));
                proteins = proteins.add(productConsumed.getProduct().getProtein()
                        .multiply(productConsumed.getGrams().divide(productConsumed.getProduct().getGrams())));
                fats = fats.add(productConsumed.getProduct().getFat()
                        .multiply(productConsumed.getGrams().divide(productConsumed.getProduct().getGrams())));
                carbohydrates = carbohydrates.add(productConsumed.getProduct().getCarbohydrates()
                        .multiply(productConsumed.getGrams().divide(productConsumed.getProduct().getGrams())));
            }
            nutrientDTO.setCalories(nutrientDTO.getCalories().add(calories));
            nutrientDTO.setProtein(nutrientDTO.getProtein().add(proteins));
            nutrientDTO.setFat(nutrientDTO.getFat().add(fats));
            nutrientDTO.setCarbohydrates(nutrientDTO.getCarbohydrates().add(carbohydrates));
        }
        return nutrientDTO;
    }
}
