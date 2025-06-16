package com.example.movieService.dto;

import lombok.Data;

@Data
public class MovieResponse {
    private Long id;
    private String title;
    private String genre;
    private Integer durationInMinutes;
}