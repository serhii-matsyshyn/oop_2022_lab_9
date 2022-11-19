package ua.edu.ucu.apps.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/all")
    public List<StoreUser> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/users/add")
    public boolean addUser(@RequestBody StoreUser user) {
        return userService.addUser(user);
    }
}
