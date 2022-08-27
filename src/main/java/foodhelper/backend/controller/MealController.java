package foodhelper.backend.controller;

import foodhelper.backend.dto.MealDTO;
import foodhelper.backend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/meals")
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody MealDTO mealDTO) {
        mealService.update(mealDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MealDTO mealDTO) {
        mealService.save(mealDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(mealService.findAllByDate(date));
    }
}
