package foodhelper.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WaterDTO {
    private Long id;
    private LocalDate date;
    private BigDecimal milliliters;
}
