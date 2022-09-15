package foodhelper.backend.controller;

import foodhelper.backend.dto.WeightDTO;
import foodhelper.backend.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/weights")
public class WeightController {
    private final WeightService weightService;

    @Autowired
    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody WeightDTO weightDTO) {
        weightService.update(weightDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody WeightDTO weightDTO) {
        weightService.save(weightDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllByDateBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        System.out.println("JESTEM");
        return ResponseEntity.ok(weightService.findAllByDateBetween(fromDate, toDate));
    }
}
