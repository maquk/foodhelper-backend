package foodhelper.backend.service;

import foodhelper.backend.dto.WaterDTO;
import foodhelper.backend.model.Water;
import foodhelper.backend.repository.WaterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class WaterService {
    private final WaterRepository waterRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public WaterService(WaterRepository waterRepository, ModelMapper modelMapper) {
        this.waterRepository = waterRepository;
        this.modelMapper = modelMapper;
    }


    public void save(WaterDTO waterDTO) {
        Water water = modelMapper.map(waterDTO, Water.class);
        if(water.getDate() == null) water.setDate(LocalDate.now());
        waterRepository.save(water);
    }

    public void update(WaterDTO waterDTO) {
        waterRepository.save(modelMapper.map(waterDTO, Water.class));
    }

    public BigDecimal findAllByDate(LocalDate date) {

        List<Water> waters = waterRepository.findAllByDate(date);

        BigDecimal milliliters = BigDecimal.ZERO;
        for (Water water : waters) {
            milliliters = milliliters.add(water.getMilliliters());
        }
        return milliliters;
    }
}
