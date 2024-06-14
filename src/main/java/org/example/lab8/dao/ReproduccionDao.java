package org.example.lab8.dao;

import org.example.lab8.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ReproduccionDao {

    private final RestTemplate restTemplate;

    public ReproduccionDao(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMmI0ODU2ZWE2NGVjYjZjN2Y4ZWRjOTZkOGMxYzRjOCIsInN1YiI6IjY2NmI4YjQ4N2QzOTFlMDBiNTcwYmIxNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ndrJJ8Kv8JmqfiMrF0cWN0OAXb3pOltDw0qgdAPn8Wc";

    public String listaCineReproduccionAuth(String titulo){
        //RestTemplate restTemplate=new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + token);

        String url = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/discover/movie")
                .queryParam("en-US", 1)
                .toUriString();

        HttpEntity<Movie> movie = new HttpEntity<>(headers);

        ResponseEntity <String> response = restTemplate.exchange(url, HttpMethod.GET, movie, String.class);

        return response.getBody();
    }


    public void guardarPeliculaFavorita(Movie movie ){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "'https://api.themoviedb.org/3/discover/movie";

        HttpEntity<Movie> httpEntity = new HttpEntity<>(movie, headers);

        RestTemplate restTemplate = new RestTemplate();
        if(movie.getIdMovie()>0){
            restTemplate.put(url, httpEntity, Movie.class);
        }else{
            restTemplate.postForEntity(url, httpEntity, Movie.class);
        }
    }


}


