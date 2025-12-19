public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserIdAndActiveTrue(Long userId);
}
