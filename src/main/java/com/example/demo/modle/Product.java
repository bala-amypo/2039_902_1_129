@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String sku;

    private String name;
    private String category;
    private BigDecimal price;
    private Boolean active = true;

    private Timestamp createdAt;

    @PrePersist
    void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
