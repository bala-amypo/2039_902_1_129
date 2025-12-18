@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product createProduct(Product p) {
        if (repo.findBySku(p.getSku()).isPresent())
            throw new IllegalArgumentException("SKU already exists");
        return repo.save(p);
    }
}
