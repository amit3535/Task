package com.movierecommenddemo.movierecommenddemo.exception;

public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String message){
        super(message);
    }
}
