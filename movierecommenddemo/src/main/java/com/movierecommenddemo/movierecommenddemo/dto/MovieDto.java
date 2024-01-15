package com.movierecommenddemo.movierecommenddemo.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
    @NotNull
    Long movieId;
    String movieTitle;
    String movieDescription;

    String filmDirector;

    String movieActors;

    String images;

    String genres;
}
