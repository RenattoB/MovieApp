package com.sistema.Entities;

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
@Table(name = "T_RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RENT")
    private Integer id_rent;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIE")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;
}
