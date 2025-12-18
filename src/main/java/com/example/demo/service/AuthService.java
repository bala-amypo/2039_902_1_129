import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigDecimal;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthService(UserRepository repo,
                       PasswordEncoder encoder,
                       JwtTokenProvider jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }
}
