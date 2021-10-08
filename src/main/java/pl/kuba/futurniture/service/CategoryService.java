package pl.kuba.futurniture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.model.Category;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.repository.CategoryRepository;
import pl.kuba.futurniture.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final ProductRepository productRepository;

    public boolean checkCategoryBindings(Long productId){
        if(productRepository.findById(productId).isPresent()){
            Product product = productRepository.getById(productId);
            if(product.getCategory()==null){
                return true;
            }
        }
        return false;
    }

}
