package com.sistema.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "T_MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOVIE")
    private Integer id_movie;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "DIRECTOR_NAME", length = 200, nullable = false)
    private String director;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;

    @Column(name = "YEAR", length = 10)
    private String year;
}
