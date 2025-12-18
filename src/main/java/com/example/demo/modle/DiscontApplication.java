@Entity
public class DiscountApplication {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private BundleRule bundleRule;

    private BigDecimal discountAmount;
    private Times@Entity
public class DiscountApplication {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private BundleRule bundleRule;

    private BigDecimal discountAmount;
    private Timestamp appliedAt;

    @PrePersist
    void applied() {
        appliedAt = new Timestamp(System.currentTimeMillis());
    }
}
tamp appliedAt;

    @PrePersist
    void applied() {
        appliedAt = new Timestamp(System.currentTimeMillis());
    }
}
