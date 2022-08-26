package foodhelper.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NutritionixResponse {
    private String food_name;
    private String brand_name;
    private BigDecimal serving_weight_grams;
    private BigDecimal nf_calories;
    private BigDecimal nf_total_fat;
    private BigDecimal nf_saturated_fat;
    private BigDecimal nf_total_carbohydrate;
    private BigDecimal nf_protein;
}
/*{
        "foods": [
        {
        "food_name": "big mac",
        "brand_name": null,
        "serving_qty": 1,
        "serving_unit": "Serving",
        "serving_weight_grams": 212,
        "nf_calories": 550,
        "nf_total_fat": 30,
        "nf_saturated_fat": 11,
        "nf_cholesterol": 80,
        "nf_sodium": 1010,
        "nf_total_carbohydrate": 45,
        "nf_dietary_fiber": 3,
        "nf_sugars": 9,
        "nf_protein": 25,
        "nf_potassium": null,
        "nf_p": null,
        "full_nutrients": [
        {
        "attr_id": 203,
        "value": 25
        },
        {
        "attr_id": 204,
        "value": 30
        },
        {
        "attr_id": 205,
        "value": 45
        },
        {
        "attr_id": 208,
        "value": 550
        },
        {
        "attr_id": 269,
        "value": 9
        },
        {
        "attr_id": 291,
        "value": 3
        },
        {
        "attr_id": 307,
        "value": 1010
        },
        {
        "attr_id": 601,
        "value": 80
        },
        {
        "attr_id": 605,
        "value": 1
        },
        {
        "attr_id": 606,
        "value": 11
        }
        ],
        "nix_brand_name": "McDonald's",
        "nix_brand_id": "513fbc1283aa2dc80c000053",
        "nix_item_name": "Big Mac",
        "nix_item_id": "513fc9e73fe3ffd40300109f",
        "upc": null,
        "consumed_at": "2022-08-25T22:40:15+00:00",
        "metadata": {
        "is_raw_food": false
        },
        "source": 1,
        "ndb_no": 21237,
        "tags": {
        "item": "Mcdonald's big mac",
        "measure": null,
        "quantity": "1",
        "food_group": null,
        "tag_id": 2583
        },
        "alt_measures": [
        {
        "serving_weight": 212,
        "measure": "Serving",
        "seq": null,
        "qty": 1
        }
        ],
        "lat": null,
        "lng": null,
        "meal_type": 5,
        "photo": {
        "thumb": "https://nix-tag-images.s3.amazonaws.com/2583_thumb.jpg",
        "highres": "https://nix-tag-images.s3.amazonaws.com/2583_highres.jpg",
        "is_user_uploaded": false
        },
        "sub_recipe": null,
        "class_code": null,
        "brick_code": null,
        "tag_id": null
        }
        ]
        */