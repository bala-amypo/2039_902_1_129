import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.security.JwtTokenProvider;

@Service
public class BundleRuleService {

    private final BundleRuleRepository repo;

    public BundleRuleService(BundleRuleRepository repo) {
        this.repo = repo;
    }

    public BundleRule createRule(BundleRule rule) {
        if (rule.getDiscountPercentage() < 0 || rule.getDiscountPercentage() > 100)
            throw new IllegalArgumentException("Invalid discount");
        return repo.save(rule);
    }
}
