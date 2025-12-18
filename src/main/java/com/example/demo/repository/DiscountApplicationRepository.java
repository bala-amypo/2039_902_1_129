public interface DiscountApplicationRepository extends JpaRepository<DiscountApplication, Long> {
    List<DiscountApplication> findByCartId(Long cartId);
}

