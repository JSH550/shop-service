package hello.shopservice.main.user;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static final Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;


    public User saveUser(User user){
        user.setId(++sequence);
        users.put(user.getId(),user);
        return user;


    };
    public User findById(Long id){
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
