import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product createProduct(Product p) {
        if (repo.findBySku(p.getSku()).isPresent())
            throw new IllegalArgumentException("SKU already exists");
        if (p.getPrice().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("price must be positive");
        return repo.save(p);
    }

    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
