package com.learning.api.controller;

import com.learning.api.dto.UserRequestDTO;
import com.learning.api.entity.User;
import com.learning.api.exception.UserNotFoundException;
import com.learning.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(this.userService.saveUser(userRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getByUserId(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }
}
