package com.service.books.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.books.Entity.User;
import com.service.books.Service.UserService;
import com.service.books.dto.UserDTO;

import lombok.Data;

@RestController
@Data
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<User> getUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User findOneUser(@PathVariable("id") Long userId) {
        return userService.findOneUser(userId);
    }

    @PostMapping
    public ResponseEntity<UserDTO<User>> addUser(@Valid @RequestBody User user, Errors errors) {

        UserDTO<User> userData = new UserDTO<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                userData.getMessage().add(error.getDefaultMessage());
            }

            userData.setStatus(false);
            userData.setPayloads(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userData);
        }

        userData.setStatus(true);
        userData.setPayloads(userService.savUser(user));

        return ResponseEntity.ok(userData);

    }

    @PutMapping
    public ResponseEntity<UserDTO<User>> updateUser(@Valid @RequestBody User user, Errors errors) {

        UserDTO<User> userData = new UserDTO<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                userData.getMessage().add(error.getDefaultMessage());
            }

            userData.setStatus(false);
            userData.setPayloads(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userData);
        }

        userData.setStatus(true);
        userData.setPayloads(userService.savUser(user));
        return ResponseEntity.ok(userData);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }

}
