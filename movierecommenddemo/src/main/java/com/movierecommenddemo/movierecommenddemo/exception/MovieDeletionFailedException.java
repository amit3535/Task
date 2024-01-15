package com.movierecommenddemo.movierecommenddemo.exception;

public class MovieDeletionFailedException extends RuntimeException{

    public MovieDeletionFailedException(String message){
        super(message);
    }
}
