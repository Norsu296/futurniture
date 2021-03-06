package pl.kuba.futurniture.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.product.model.Product;
import pl.kuba.futurniture.order.repository.OrderRepository;
import pl.kuba.futurniture.product.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final EntityManager entityManager;

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

    public List<Product> search(String keyword){
        return productRepository.search(keyword);
    }

}
