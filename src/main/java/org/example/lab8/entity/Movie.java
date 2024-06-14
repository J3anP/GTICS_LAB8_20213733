package org.example.lab8.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovie", nullable = false)
    private Integer idMovie;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "overview", nullable = false, length = 255)
    private String overview;

    @Column(name = "popularidad", nullable = false, length = 256)
    private Integer popularidad;

    @Column(name = "fecha_lanzamiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLanzamiento;

    @ManyToOne
    @JoinColumn(name = "iduser",nullable = false)
    private User user;

}
