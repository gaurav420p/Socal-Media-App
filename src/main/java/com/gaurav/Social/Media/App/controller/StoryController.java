package com.gaurav.Social.Media.App.controller;

import com.gaurav.Social.Media.App.model.Story;
import com.gaurav.Social.Media.App.model.User;
import com.gaurav.Social.Media.App.service.StoryService;
import com.gaurav.Social.Media.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/story")
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) {
        User reqUser = userService.findUserByJwt(jwt);
        return storyService.createStory(story, reqUser);
    }

    @GetMapping("/api/story/user/{userId}")
    public List<Story> findUsersStory(@PathVariable Integer userId,
                                      @RequestHeader("Authorization") String jwt) throws Exception {
        userService.findUserByJwt(jwt); // Optional: remove if not used
        return storyService.findStoryByUserId(userId);
    }
}
