package com.example.tmdb.validator;

import com.example.tmdb.dto.CommentFormData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CommentFormDetailsValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return CommentFormData.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CommentFormData commentFormData = (CommentFormData) o;

        if (commentFormData.getCommentBody() == null || commentFormData.getCommentBody().isEmpty()) {
            errors.rejectValue("commentBody", "commentFormData.commentBody.empty");
        }
    }
}
