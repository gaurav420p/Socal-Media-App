package com.gaurav.Social.Media.App.service;

import com.gaurav.Social.Media.App.model.Reels;
import com.gaurav.Social.Media.App.model.User;
import com.gaurav.Social.Media.App.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImplementation implements ReelsService {

    @Autowired
    ReelsRepository reelsRepository;
    @Autowired
    UserService userService;


    @Override
    public Reels createReel(Reels reel, User user) {

        Reels createReel = new Reels();

        createReel.setTitle(reel.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reel.getVideo());

        return reelsRepository.save(createReel);

    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUsersReel(Integer userId) throws Exception {
        userService.findUserById(userId);

        return  reelsRepository.findByUserId(userId);
    }
}
