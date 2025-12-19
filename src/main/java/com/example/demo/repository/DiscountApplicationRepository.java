public interface DiscountApplicationRepository extends JpaRepository<DiscountApplication, Long> {
    void deleteByCartId(Long cartId);
    List<DiscountApplication> findByCartId(Long cartId);
}
