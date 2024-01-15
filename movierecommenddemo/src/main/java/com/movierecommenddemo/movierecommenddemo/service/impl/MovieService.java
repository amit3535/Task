package com.movierecommenddemo.movierecommenddemo.service.impl;


import com.movierecommenddemo.movierecommenddemo.dto.MovieDto;
import com.movierecommenddemo.movierecommenddemo.entities.Movie;

public interface MovieService {
    Movie getMoviesFromID(String movieId);
    Movie addorUpdateMovie(MovieDto movieDto);
    void deleteMovieDetails(String movieId);
}
