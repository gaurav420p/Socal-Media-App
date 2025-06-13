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


    @GetMapping("/api/users")
    public List<User> getUsers(){
        List<User> users=userRepository.findAll();
        return users;
    }


    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId") int id) throws Exception {
        User user=userService.findUserById(id);
        return user;

    }



    @PutMapping("/api/users")
    public User updateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        User updatedUser=userService.updateUser(user,reqUser.getId());
        return updatedUser;
    }

    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler( @RequestHeader("Authorization") String jwt,@PathVariable Integer userId2) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        User user = userService.followUser(reqUser.getId(), userId2);
        return user;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        List<User> users = userService.searchUser(query);
        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt){
        User user=userService.findUserByJwt(jwt);
        return user;
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
