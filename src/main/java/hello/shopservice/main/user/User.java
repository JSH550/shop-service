package hello.shopservice.main.user;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;


@Data
public class User {
//    private UUID id;
    private Long id;
    private String userId;
    private String userName;



}
