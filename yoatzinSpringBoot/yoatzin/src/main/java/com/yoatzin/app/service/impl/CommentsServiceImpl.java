package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Comments;
import com.yoatzin.app.repository.CommentsRepository;
import com.yoatzin.app.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
    
    //@Autowired
    CommentsRepository commentsRepository;
    
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    
    @Override
    public Comments createComments(Comments comments) {
        Comments newComments = commentsRepository.save(comments);
        return newComments;
    }
}
