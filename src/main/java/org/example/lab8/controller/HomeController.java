package org.example.lab8.controller;


import org.example.lab8.entity.Movie;
import org.example.lab8.repository.MovieRepository;
import org.example.lab8.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HomeController {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public HomeController(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }



}
