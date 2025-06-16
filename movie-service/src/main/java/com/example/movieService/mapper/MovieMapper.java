package com.example.movieService.mapper;

import com.example.movieService.dto.MovieRequest;
import com.example.movieService.dto.MovieResponse;
import com.example.movieService.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie toEntity(MovieRequest request) {
        return Movie.builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .durationInMinutes(request.getDurationInMinutes())
                .build();
    }

    public MovieResponse toResponse(Movie movie) {
        MovieResponse response = new MovieResponse();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setGenre(movie.getGenre());
        response.setDurationInMinutes(movie.getDurationInMinutes());
        return response;
    }
}
