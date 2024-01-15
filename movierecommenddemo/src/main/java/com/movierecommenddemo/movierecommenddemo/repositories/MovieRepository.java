package com.movierecommenddemo.movierecommenddemo.repositories;

import com.movierecommenddemo.movierecommenddemo.entities.Movie;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

    Movie findByMovieId(String movieId);
}