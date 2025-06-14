package com.gaurav.Social.Media.App.service;

import com.gaurav.Social.Media.App.model.Story;
import com.gaurav.Social.Media.App.model.User;

import java.util.List;

public interface StoryService {

    public Story createStory(Story story, User user);

    public List<Story> findStoryByUserId(Integer userId) throws Exception;
}
