package br.com.ebac.user.controller;

import br.com.ebac.user.entity.Users;
import br.com.ebac.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Users createUsers(@RequestBody Users users) {
        logger.info("Creating usuario: {}", users);
        Users createdUser = userService.createUsers(users);
        logger.info("Usuario created: {}", createdUser);
        return createdUser;
    }

    @GetMapping
    public Iterable<Users> findThemAll() {
        logger.info("Find all users");
        Iterable<Users> users = userService.findThemAll();
        logger.info("Found {} usuarios", users.spliterator().getExactSizeIfKnown());
        return users;
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable Long id) {
        logger.info("Find user with id: {} ", id);
        Users users = userService.findById(id);
        logger.info("Found usuario: {}", users);
        return users;
    }

}
