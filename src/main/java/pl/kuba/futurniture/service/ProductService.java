package pl.kuba.futurniture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.model.OrderStatus;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.repository.OrderRepository;
import pl.kuba.futurniture.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public void save(Product product){
        productRepository.save(product);
    }
    public void remove(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        return productRepository.findById(id).get();
    }
    public void changeAvailable(Long id){
        Product product = productRepository.findById(id).get();
        product.setAvailable(!product.isAvailable());
        productRepository.save(product);
    }
    public List<Product> filterByAvailable(String param){
        if(param.equals("available")){
            return productRepository.findAllByAvailable(true);
        }else if(param.equals("unavailable")) {
            return productRepository.findAllByAvailable(false);
        }else return null;
    }
    public List<Product> filterByCategory(Long categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }


    public boolean checkProductBindings(Long productId){
        if(orderRepository.findByProductsId(productId).isPresent()){
            return false;
        }
        return true;

    }

}
