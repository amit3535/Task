package com.movierecommenddemo.movierecommenddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Object> handleMovieNotFoundException(MovieNotFoundException movieNotFoundException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(movieNotFoundException.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Object> handleMovieAlreadyExist(MovieAlreadyExistException movieAlreadyExistException){
        return ResponseEntity
                .status(HttpStatus.ALREADY_REPORTED)
                .body(movieAlreadyExistException.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MovieCreationFailedException.class)
    public ResponseEntity<Object> handleMovieCreationFailedException(MovieCreationFailedException movieCreationFailedException){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(movieCreationFailedException.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MovieDeletionFailedException.class)
    public ResponseEntity<Object> handleMovieDeletionFailedException(MovieDeletionFailedException movieDeletionFailedException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(movieDeletionFailedException.getMessage());
    }
}
