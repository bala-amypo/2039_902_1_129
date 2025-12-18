@Entity
public class BundleRule {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String requiredProducts; // CSV
    private Double discountPercentage;
    private Boolean active = true;
}
