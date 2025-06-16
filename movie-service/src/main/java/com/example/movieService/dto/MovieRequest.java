package com.example.movieService.dto;

import lombok.Data;

@Data
public class MovieRequest {
    private String title;
    private String genre;
    private Integer durationInMinutes;
}