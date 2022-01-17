package by.tms.springapi.controller;

import by.tms.springapi.entity.User;
import by.tms.springapi.exception.userException.UserAlreadyExistException;
import by.tms.springapi.exception.userException.UserNotExistException;
import by.tms.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createWithList")
    public ResponseEntity<?> createWithList(@RequestBody List<User> users) {
        try {
            userService.saveAllUsers(users);
            return ResponseEntity.ok("successful operation");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("successful operation");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        try {
            return ResponseEntity.ok(userService.findByUsername(username));
        } catch (UserNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{username}")
    public ResponseEntity<?> update(@PathVariable("username") String username, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (UserNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable("username") String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok("successful delete");
        } catch (UserNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
