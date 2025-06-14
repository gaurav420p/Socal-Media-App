package com.gaurav.Social.Media.App.controller;

import com.gaurav.Social.Media.App.model.Reels;
import com.gaurav.Social.Media.App.model.User;
import com.gaurav.Social.Media.App.service.ReelsService;
import com.gaurav.Social.Media.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    ReelsService reelsService;
    @Autowired
    UserService userService;

    @PostMapping("/api/reels")
    public Reels createReels(@RequestBody Reels reel,
                             @RequestHeader("Authorization") String jwt) {

        User reqUser = userService.findUserByJwt(jwt);

        Reels createdReels = reelsService.createReel(reel, reqUser);

        return createdReels;
    }

    @GetMapping("/api/reels")
    public List<Reels> findAllReels() {

        List<Reels> reels = reelsService.findAllReels();

        return reels;
    }

    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findUsersReels(@PathVariable Integer userId) throws Exception {

        List<Reels> reels = reelsService.findUsersReel(userId);

        return reels;
    }
}
