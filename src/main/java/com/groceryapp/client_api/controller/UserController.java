package com.groceryapp.client_api.controller;

import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    public  ResponseEntity<User> createUser(@RequestBody User user)  {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK );
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return new ResponseEntity<>( userService.deleteUserById(id), HttpStatus.OK);
    }


}
