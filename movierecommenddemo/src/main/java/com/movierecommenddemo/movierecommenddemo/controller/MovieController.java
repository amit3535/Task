package com.movierecommenddemo.movierecommenddemo.controller;

import com.movierecommenddemo.movierecommenddemo.dto.MovieDto;
import com.movierecommenddemo.movierecommenddemo.entities.Movie;
import com.movierecommenddemo.movierecommenddemo.service.impl.MovieServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieApi")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;
    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping(name = "/getMovieDetails/{movieId}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable String movieId){
        logger.info("Movie ID received from user="+movieId);
        Movie movie = movieService.getMoviesFromID(movieId);
        return ResponseEntity.ok(movie);
    }

    @PostMapping(name = "/addMovie")
    public ResponseEntity<Movie> createMovie(@Valid MovieDto movieDto){
        logger.info("Movie creation initiated");
        Movie movie = movieService.addorUpdateMovie(movieDto);
        return ResponseEntity.ok(movie);
    }

    @PutMapping(name = "/updateMovieDetails")
    public ResponseEntity updateMovieDetails(@Valid MovieDto movieDto){
        logger.info("Movie details updation initiated");
        Movie movie = movieService.addorUpdateMovie(movieDto);
        logger.info("Movie details updated successfully");
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping(name = "/deleteMovie/{movieId}")
    public void deleteMovie(@PathVariable String movieId){
        logger.info("Initiating Delete operation");
        movieService.deleteMovieDetails(movieId);

    }
}
