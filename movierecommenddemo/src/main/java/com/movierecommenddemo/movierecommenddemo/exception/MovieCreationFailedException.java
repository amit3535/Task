package com.movierecommenddemo.movierecommenddemo.exception;

public class MovieCreationFailedException extends RuntimeException {

    public MovieCreationFailedException(String message){
        super(message);
    }
}
