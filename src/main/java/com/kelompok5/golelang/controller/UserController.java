package com.kelompok5.golelang.controller;

import com.kelompok5.golelang.entity.User;
import com.kelompok5.golelang.service.UserErrorService;
import com.kelompok5.golelang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserErrorService userErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMessage = userErrorService.errorMessageService(result);
        if(errorMessage != null){
            return errorMessage;
        }
        User user1 = userService.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String userName) {
        User user = userService.findUserByUsername(userName);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUser(){
        return userService.findAllUsers();
    }

}
