import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.security.JwtTokenProvider;

@Service
public class DiscountService {

    private final BundleRuleRepository bundleRepo;
    private final CartItemRepository itemRepo;
    private final DiscountApplicationRepository discountRepo;

    public DiscountService(BundleRuleRepository bundleRepo,
                           CartItemRepository itemRepo,
                           DiscountApplicationRepository discountRepo) {
        this.bundleRepo = bundleRepo;
        this.itemRepo = itemRepo;
        this.discountRepo = discountRepo;
    }

    public List<DiscountApplication> evaluateDiscounts(Long cartId) {

        List<CartItem> items = itemRepo.findByCartId(cartId);
        Set<Long> productIds = items.stream()
                .map(i -> i.getProduct().getId())
                .collect(Collectors.toSet());

        List<DiscountApplication> applied = new ArrayList<>();

        for (BundleRule rule : bundleRepo.findByActiveTrue()) {
            Set<Long> required = Arrays.stream(rule.getRequiredProducts().split(","))
                    .map(Long::valueOf).collect(Collectors.toSet());

            if (productIds.containsAll(required)) {
                DiscountApplication da = new DiscountApplication();
                da.setDiscountAmount(BigDecimal.TEN);
                applied.add(discountRepo.save(da));
            }
        }
        return applied;
    }
}
