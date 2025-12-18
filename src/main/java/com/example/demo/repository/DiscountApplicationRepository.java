import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DiscountApplicationRepository extends JpaRepository<DiscountApplication, Long> {
    List<DiscountApplication> findByCartId(Long cartId);
}

