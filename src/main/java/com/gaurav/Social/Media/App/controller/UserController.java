package com.gaurav.Social.Media.App.controller;

import com.gaurav.Social.Media.App.model.User;
import com.gaurav.Social.Media.App.repository.UserRepository;
import com.gaurav.Social.Media.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        User savedUser=userService.registerUser(user);
        return savedUser;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users=userRepository.findAll();
        return users;
    }


    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int id) throws Exception {
        User user=userService.findUserById(id);
        return user;

    }



    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") int id) throws Exception {
        User updatedUser=userService.updateUser(user,id);
        return updatedUser;
    }

    @PutMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        User user = userService.followUser(userId1, userId2);
        return user;
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        List<User> users = userService.searchUser(query);
        return users;
    }






//    @DeleteMapping("/users/{userId}")
//    public String deleteUser(@PathVariable("userId") int userId) throws Exception {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isEmpty()) {
//            throw new Exception("User not found with ID -> " + userId);
//        }
//        userRepository.delete(user.get());
//        return "User deleted successfully with ID " + userId;
//    }



}
