package com.gaurav.Social.Media.App.repository;

import com.gaurav.Social.Media.App.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
