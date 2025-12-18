@Service
public class DiscountService {

    private final BundleRuleRepository bundleRepo;
    private final CartItemRepository cartItemRepo;
    private final DiscountApplicationRepository discountRepo;

    public DiscountService(BundleRuleRepository b,
                           CartItemRepository c,
                           DiscountApplicationRepository d) {
        this.bundleRepo = b;
        this.cartItemRepo = c;
        this.discountRepo = d;
    }

    public void evaluateDiscounts(Long cartId) {

        List<CartItem> items = cartItemRepo.findByCartId(cartId);
        Set<Long> productIds = items.stream()
                .map(i -> i.getProduct().getId())
                .collect(Collectors.toSet());

        for (BundleRule rule : bundleRepo.findByActiveTrue()) {
            Set<Long> required = Arrays.stream(rule.getRequiredProductIds().split(","))
                    .map(Long::valueOf)
                    .collect(Collectors.toSet());

            if (productIds.containsAll(required)) {
                BigDecimal total = items.stream()
                        .map(i -> i.getProduct().getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                BigDecimal discount =
                        total.multiply(BigDecimal.valueOf(rule.getDiscountPercentage() / 100));

                DiscountApplication da = new DiscountApplication();
                da.setDiscountAmount(discount);
                discountRepo.save(da);
            }
        }
    }
}
