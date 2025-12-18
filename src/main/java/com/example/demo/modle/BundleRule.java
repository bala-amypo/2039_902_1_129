@Entity
public class BundleRule {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String requiredProductIds; // CSV "1,2,3"
    private Double discountPercentage;
    private Boolean active = true;
}
