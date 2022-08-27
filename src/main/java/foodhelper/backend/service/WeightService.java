package foodhelper.backend.service;

import foodhelper.backend.dto.ProductDTO;
import foodhelper.backend.dto.WeightDTO;
import foodhelper.backend.model.Weight;
import foodhelper.backend.repository.WeightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeightService {
    private final WeightRepository weightRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public WeightService(WeightRepository weightRepository, ModelMapper modelMapper) {
        this.weightRepository = weightRepository;
        this.modelMapper = modelMapper;
    }

    public void save(WeightDTO weightDTO) {
        Weight weight = modelMapper.map(weightDTO, Weight.class);
        if(weight.getDate() == null) weight.setDate(LocalDate.now());
        weightRepository.save(weight);
    }

    public void update(WeightDTO weightDTO) {
        weightRepository.save(modelMapper.map(weightDTO, Weight.class));
    }

    public List<WeightDTO> findAllByDateBetween(LocalDate fromDate, LocalDate toDate) {
        List<Weight> weights = weightRepository.findAllByDateBetween(fromDate, toDate);
        return weights.stream()
                .map(weight -> modelMapper.map(weight, WeightDTO.class)).collect(Collectors.toList());
    }

}
