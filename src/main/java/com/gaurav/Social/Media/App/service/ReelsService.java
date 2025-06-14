package com.gaurav.Social.Media.App.service;

import com.gaurav.Social.Media.App.model.Reels;
import com.gaurav.Social.Media.App.model.User;

import java.util.List;

public interface ReelsService {

    public Reels createReel(Reels reel, User user);

    public List<Reels> findAllReels();

    public List<Reels> findUsersReel(Integer userId) throws Exception;


}
