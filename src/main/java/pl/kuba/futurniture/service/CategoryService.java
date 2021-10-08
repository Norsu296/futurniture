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
    private final CategoryRepository categoryRepository;

    public void save(Category category){
        categoryRepository.save(category);
    }
    public void remove(Long id){
        categoryRepository.deleteById(id);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }


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
