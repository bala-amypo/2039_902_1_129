public class Cart(){
    
}@Entity
public class Cart {

    @Id @GeneratedValue
    private Long id;

    private Long userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    void create() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
