package com.example.movieService.service.impl;

import com.example.movieService.dto.MovieRequest;
import com.example.movieService.dto.MovieResponse;
import com.example.movieService.entity.Movie;
import com.example.movieService.exception.MovieNotFoundException;
import com.example.movieService.mapper.MovieMapper;
import com.example.movieService.repository.MovieRepository;
import com.example.movieService.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieResponse addMovie(MovieRequest movieRequest) {
        Movie movie =  movieMapper.toEntity(movieRequest);
        return movieMapper.toResponse(movieRepository.save(movie));
    }

    @Override
    public List<MovieResponse> getAllMovie() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .map(movieMapper::toResponse)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: "));
    }

    @Override
    public List<MovieResponse> getMoviesByGenre(String genre) {
//        return movieRepository.findAll().stream()
//                .filter(movie -> movie.getGenre().equals(genre))
//                .map(movieMapper::toResponse)
//                .collect(Collectors.toList());
        return movieRepository.findByGenre(genre).stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMovieById(Long movieId) {
        Movie movie =movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: "));
        if(movie != null)
            movieRepository.deleteById(movieId);
    }
}
