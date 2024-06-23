package com.developerjugad.fiteasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developerjugad.fiteasy.db.entity.Users;
import com.developerjugad.fiteasy.service.UsersService;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) String gender) {
        return new ResponseEntity<>(usersService.getAllUsers(gender), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUser(@PathVariable int id) {
        return new ResponseEntity<>(usersService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
