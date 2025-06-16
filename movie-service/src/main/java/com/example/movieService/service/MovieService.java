package com.example.movieService.service;

import com.example.movieService.dto.MovieRequest;
import com.example.movieService.dto.MovieResponse;
import com.example.movieService.entity.Movie;

import java.util.List;

public interface MovieService {
    MovieResponse addMovie(MovieRequest movieRequest);
    List<MovieResponse> getAllMovie();
    MovieResponse getMovieById(Long movieId);
    List<MovieResponse> getMoviesByGenre(String genre);
    void deleteMovieById(Long movieId);
}
