package com.movierecommenddemo.movierecommenddemo.entities;

import com.movierecommenddemo.movierecommenddemo.dto.MovieDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movie")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "movieId")
    Long movieId;
    @Column(name = "movieTitle")
    String movieTitle;
    @Column(name = "movieDescription")
    String movieDescription;
    @Column(name = "filmDirector")
    String filmDirector;
    @Column(name = "movieActors")
    String movieActors;
    @Column(name = "images")
    String images;
    @Column(name = "genres")
    String genres;

    public static Movie getMovieFromDto(MovieDto movieDto){
        return Movie.builder()
                .movieId(movieDto.getMovieId())
                .movieTitle(movieDto.getMovieTitle())
                .movieDescription(movieDto.getMovieDescription())
                .filmDirector(movieDto.getFilmDirector())
                .movieActors(movieDto.getMovieActors())
                .images(movieDto.getImages())
                .genres(movieDto.getGenres())
                .build();
    }


}
