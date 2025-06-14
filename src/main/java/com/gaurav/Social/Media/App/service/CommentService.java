package com.gaurav.Social.Media.App.service;

import com.gaurav.Social.Media.App.model.Comment;

import org.springframework.stereotype.Service;


public interface CommentService {
    public Comment createComment (Comment comment,
                                  Integer postId,
                                  Integer userId) throws Exception;
    public Comment findCommentById(Integer commentId) throws Exception;
    public Comment likeComment(Integer CommentId,Integer userId ) throws Exception;

}
