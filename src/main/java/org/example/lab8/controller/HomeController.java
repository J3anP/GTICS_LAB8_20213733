package org.example.lab8.controller;


import ch.qos.logback.core.model.Model;
import org.example.lab8.dao.ReproduccionDao;
import org.example.lab8.entity.Movie;
import org.example.lab8.repository.MovieRepository;
import org.example.lab8.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HomeController {
    private final ReproduccionDao reproduccionDao;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public HomeController(ReproduccionDao reproduccionDao, MovieRepository movieRepository, UserRepository userRepository) {
        this.reproduccionDao = reproduccionDao;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }



    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(value = "titulo", required = false) String titulo) {
        HashMap<String, Object> response = new HashMap<>();
        if(titulo == null || titulo.isEmpty()){
            response.put("status","no hay pelicula | error");
        }
        ArrayList<HashMap<String,Object>>listaFilms=new ArrayList<>();
        List<String> listaGet= reproduccionDao.listaCineReproduccionAuth(titulo);

        return ResponseEntity.ok(response);
    }

}
