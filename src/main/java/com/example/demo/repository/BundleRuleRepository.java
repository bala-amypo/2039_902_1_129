public interface BundleRuleRepository extends JpaRepository<BundleRule, Long> {
    List<BundleRule> findByActiveTrue();
}
