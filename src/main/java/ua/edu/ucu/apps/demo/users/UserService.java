package ua.edu.ucu.apps.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<StoreUser> getUsers() {
        return userRepository.findAll();
    }

    public boolean addUser(StoreUser user) {
        if (userRepository.findStoreUserByEmail(user.getEmail()).isEmpty()) {
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
