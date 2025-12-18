@Service
public class CartService {

    private final CartRepository repo;

    public CartService(CartRepository repo) {
        this.repo = repo;
    }

    public Cart createCart(Long userId) {
        if (repo.findByUserId(userId).isPresent())
            throw new IllegalArgumentException("Cart already exists");
        Cart c = new Cart();
        c.setUserId(userId);
        return repo.save(c);
    }
}
