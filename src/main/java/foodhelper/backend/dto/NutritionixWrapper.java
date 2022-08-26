package foodhelper.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class NutritionixWrapper {
    List<NutritionixResponse> foods;
}
