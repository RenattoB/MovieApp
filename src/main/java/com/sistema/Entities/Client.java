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
@Table(name = "T_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private Integer id_client;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "LASTNAME", length = 100, nullable = false)
    private String lastname;

}
