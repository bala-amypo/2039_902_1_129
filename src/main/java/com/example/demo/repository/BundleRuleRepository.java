import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface BundleRuleRepository extends JpaRepository<BundleRule, Long> {
    List<BundleRule> findByActiveTrue();
}
