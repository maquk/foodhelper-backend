package foodhelper.backend.service;

import foodhelper.backend.dto.ProductDTO;
import foodhelper.backend.exception.EntityNotFoundException;
import foodhelper.backend.model.Product;
import foodhelper.backend.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private final NutritionixService nutritionixService;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, NutritionixService nutritionixService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.nutritionixService = nutritionixService;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());

    }

    public ProductDTO findByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);

        if(productOptional.isPresent()) {
            return modelMapper.map(productOptional.get(), ProductDTO.class);
        }

        nutritionixService.fetchProducts(name);

        Product product = productRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Product with name " + name + " not found"));

        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    public void save(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);
    }

    public void update(ProductDTO productDTO) {
        productRepository.save(modelMapper.map(productDTO, Product.class));

    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
