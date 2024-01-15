package com.movierecommenddemo.movierecommenddemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MovieGenre")
public class MovieGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "movieId")
    Long movieId;
    @Column(name = "genre")
    String genre;

}
