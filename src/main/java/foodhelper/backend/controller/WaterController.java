package foodhelper.backend.controller;

import foodhelper.backend.dto.WaterDTO;
import foodhelper.backend.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/waters")
public class WaterController {
    private final WaterService waterService;

    @Autowired
    public WaterController(WaterService waterService) {
        this.waterService = waterService;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody WaterDTO waterDTO) {
        waterService.update(waterDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody WaterDTO waterDTO) {
        waterService.save(waterDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(waterService.findAllByDate(date));
    }
}
