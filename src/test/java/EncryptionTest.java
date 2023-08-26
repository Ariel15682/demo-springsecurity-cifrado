import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    @Test
    void pbkdf2() {
        for (int i = 0; i < 5; i++){
            Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("1234", 8, 185000,
                    Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA1);
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    // DON'T WORK
    @Test
    void argon() {

        for (int i = 0; i < 5; i++){
            Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 32,1,
                    16384, 2 );
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    // DON'T WORK
    @Test
    void scrypt() {

        for (int i = 0; i < 5; i++){
            SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder(65536, 8, 1,
                    32, 16);
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void springPasswordEncoders() {

        String idForEncode = "pbkdf2";

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8()); // no funciona
        encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8()); // no funciona

        //No seguros-Deprecados
        //encoders.put("noop", NoOpPasswordEncoder.getInstance());
        //encoders.put("SHA256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders); //(texto, mapa)

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
    }
}