package com.example.tmdb.controller;


import com.example.tmdb.domain.Comment;
import com.example.tmdb.dto.CommentDetails;
import com.example.tmdb.dto.CommentFormData;
import com.example.tmdb.service.CommentService;
import com.example.tmdb.validator.CommentFormDetailsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private CommentService commentService;
    private CommentFormDetailsValidator commentFormDetailsValidator;

    @Autowired
    public CommentController(CommentService commentService,
                             CommentFormDetailsValidator commentFormDetailsValidator) {
        this.commentService = commentService;
        this.commentFormDetailsValidator = commentFormDetailsValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(commentFormDetailsValidator);
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@Validated @RequestBody CommentFormData commentFormData) {
        logger.info("New comment is created");
        Comment commentCreated = commentService.createComment(commentFormData);
        if (commentCreated != null) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
