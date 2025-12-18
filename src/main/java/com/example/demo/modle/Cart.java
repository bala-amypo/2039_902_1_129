@Entity
public class Cart {

    @Id @GeneratedValue
    private Long id;

    private Long userId;
    private Boolean active = true;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    void created() {
        createdAt = updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    void updated() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
