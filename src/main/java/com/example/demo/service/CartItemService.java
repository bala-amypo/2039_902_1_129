@Service
public class CartItemService {

    private final CartItemRepository itemRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public CartItemService(CartItemRepository itemRepo,
                           CartRepository cartRepo,
                           ProductRepository productRepo) {
        this.itemRepo = itemRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public CartItem addItem(Long cartId, Long productId, Integer qty) {
        if (qty <= 0)
            throw new IllegalArgumentException("Quantity must be positive");

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(qty);

        return itemRepo.save(item);
    }
}
