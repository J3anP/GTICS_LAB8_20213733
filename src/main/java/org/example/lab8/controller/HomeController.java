package org.example.lab8.controller;


import org.example.lab8.repository.MovieRepository;
import org.example.lab8.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public HomeController(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

}
