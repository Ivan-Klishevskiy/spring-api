package by.tms.springapi.controller;

import by.tms.springapi.entity.User;
import by.tms.springapi.exception.UserAlreadyExistException;
import by.tms.springapi.exception.UserNotExistException;
import by.tms.springapi.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody User user) {
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
    public ResponseEntity getUser(@PathVariable("username")String username){
        try {
            return ResponseEntity.ok(userService.findByUsername(username));
        } catch (UserNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
