package com.movierecommenddemo.movierecommenddemo.service.impl;

import com.movierecommenddemo.movierecommenddemo.controller.MovieController;
import com.movierecommenddemo.movierecommenddemo.dto.MovieDto;
import com.movierecommenddemo.movierecommenddemo.entities.Movie;
import com.movierecommenddemo.movierecommenddemo.exception.MovieCreationFailedException;
import com.movierecommenddemo.movierecommenddemo.exception.MovieNotFoundException;
import com.movierecommenddemo.movierecommenddemo.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    MovieRepository movieRepository;

    public Movie getMoviesFromID(String movieId){
        logger.info("[MovieServiceImpl] Fetching movie details from database.");
        Movie movie = movieRepository.findByMovieId(movieId);
        return Optional.ofNullable(movie).orElseThrow(() -> new MovieNotFoundException("[MovieServiceImpl] The movie is not available for ID="+movieId));
    }

    public Movie addorUpdateMovie(MovieDto movieDto){
        Movie movie = Movie.getMovieFromDto(movieDto);
        logger.info("[MovieServiceImpl] Movie creation started.");
        try{
            Movie savedMovie = movieRepository.save(movie);
            logger.info("[MovieServiceImpl] Successfully saved/updated the Movie details for ID={}",movie.getMovieId());
            return savedMovie;
        }catch (Exception exception){
            logger.error("[MovieServiceImpl] Failed to save/update Movie in database.", exception);
            throw new MovieCreationFailedException("[MovieServiceImpl] Failed to save/update movie in database.");
        }
    }

    public void deleteMovieDetails(String movieId){
        Movie movie = movieRepository.findByMovieId(movieId);
        if(Objects.nonNull(movie)){
            movieRepository.delete(movie);
        }else {
            logger.error("[MovieServiceImpl] Movie with ID {} is not available in system.",movieId);
        }

    }


}
