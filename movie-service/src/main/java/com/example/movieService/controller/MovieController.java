package com.example.movieService.controller;

import com.example.movieService.dto.MovieRequest;
import com.example.movieService.dto.MovieResponse;
import com.example.movieService.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRequest));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAll() {
        return ResponseEntity.ok(movieService.getAllMovie());
    }

    @GetMapping("{movieId}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
    @DeleteMapping("{movieId}")
    public ResponseEntity<String> deletMovieById(@PathVariable Long movieId) {
        movieService.deleteMovieById(movieId);
        return ResponseEntity.ok("Succuessfully deleted movie with id: " + movieId);
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponse>> getByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }
}
